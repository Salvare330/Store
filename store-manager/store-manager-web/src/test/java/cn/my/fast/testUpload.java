package cn.my.fast;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import cn.my.store.common.util.FastDFSClient;
public class testUpload {
	String path = "D:/Workspaces/EclipseEE/store-manager/store-manager-web/src/main/resources/conf/client.conf";

	public void testupload() throws Exception{
		ClientGlobal.init(path);
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		String[] strings = storageClient.upload_file("D:/照片.jpg", "jpg", null);
		for(String url:strings) {
			System.out.println(url);
		}
	}

	public void testFastDFSClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient(path);
		String string = fastDFSClient.uploadFile("D:/Workspaces/EclipseEE/store-manager/store-manager-web/src/main/resources/conf/client.conf");
		System.out.println(string);
	}
}
