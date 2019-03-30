package lava.ct.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DiffPatchMain {

	public static void main(String[] args) throws Exception {

		if (args.length < 3) {
			String errorMsg = "请参考以下命令格式: \n java -cp jc_common-0.0.1-SNAPSHOT.jar " + DiffPatchMain.class.getName();
			errorMsg += " 旧.war  新.war  输出目录  ";
			System.out.println(errorMsg);
			return;
		}

		try (JarFile jarNew = new JarFile(args[1]); JarFile jarOld = new JarFile(args[0]);) {
			String diffRoot = args[2];

			File diffDir = new File(diffRoot);

			diffDir.mkdirs();

			Enumeration<JarEntry> entries = jarNew.entries(), oldEtries = jarOld.entries();

			Map<String, JarEntry> oldEntryMap = new HashMap<>();
			while (oldEtries.hasMoreElements()) {
				JarEntry entry = oldEtries.nextElement();

				if (entry.isDirectory())
					continue;

				String key = genKey(entry);
				oldEntryMap.put(key, entry);

			}

			// 遍历条目。
			while (entries.hasMoreElements()) {
				// 参考api获取你需要的文件信息。
				JarEntry entry = entries.nextElement();

				if (entry.isDirectory())
					continue;

				String key = genKey(entry);

				if (oldEntryMap.containsKey(key))
					continue;

				String msg = key;
				// msg+="\n"+br.readLine();
				// br.close();
				// is.close();
				createFile(diffRoot, jarNew, entry);
				System.out.println(msg);
			}

		}

	}

	static int bufferSize = 2048;

	private static void createFile(String diffRoot, JarFile jarFile, JarEntry entry) throws IOException {
		// TODO Auto-generated method stub
		String dir = entry.toString(), file = diffRoot + "/" + entry.toString();
		dir = dir.substring(0, dir.lastIndexOf("/"));
		dir = diffRoot + "/" + dir;

		String msg = "diffpath:" + file;
		File fileDir = new File(dir), filePath = new File(file);
		if (!fileDir.exists())
			fileDir.mkdirs();

		// filePath.deleteOnExit();
		if (!filePath.createNewFile()) {
			throw new IOException("create fail:" + file);
		}

		try (InputStream in = jarFile.getInputStream(entry);

				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos, bufferSize);

		) {

			byte[] buf = new byte[bufferSize];
			int count = 0;

			while ((count = in.read(buf)) > -1) {
				bos.write(buf, 0, count);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println(msg);
	}

	private static String genKey(JarEntry entry) {
		return entry + " " + entry.getTime();
	}

	

}
