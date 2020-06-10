package test3;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;


public class hdfsTest {

	/** @description : 获取 HDFS文件目录 */
    private static FileSystem getFileSystem() throws IOException, URISyntaxException{
        //read config file
        Configuration conf = new Configuration();
        URI uri = new URI("test3.hdfsTest://hy:9000");
        FileSystem fs = FileSystem.get(uri, conf);
        return fs;
    }



    /** @description : 创建文件目录 */
    public static void mkdir() throws Exception{
        FileSystem fs = getFileSystem();
        fs.mkdirs(new Path("test3.hdfsTest://hy:9000/hy/weibo"));
        fs.close();
    }



    /** @description : 删除文件目录 */
    public static void rmdir() throws Exception{
        FileSystem fs = getFileSystem();
        fs.delete(new Path("test3.hdfsTest://hy:9000/hy/weibo"), true);
        fs.close();
    }



    /** @description : 列出所有文件 */
    public static void listAllFile() throws Exception{
        FileSystem fs = getFileSystem();
        FileStatus[] status = fs.listStatus(new Path("test3.hdfsTest://hy:9000/hy/"));
        Path[] listedPaths = FileUtil.stat2Paths(status);
        fs.close();
    }



    /** @description : copy */
    public static void copyToHDFS() throws Exception{
        FileSystem fs = getFileSystem();
        //Դ�ļ�·����Linux�µ�·�� Path srcPath = new Path("/home/hadoop/temp.jar");
        //�����Ҫ��windows�²��ԣ���Ҫ��ΪWindows�µ�·�������� E://temp.jar
        Path srcPath = new Path("E://temp.jar");
        Path dstPath = new Path("test3.hdfsTest://hy:9000/hy/weibo");
        fs.copyFromLocalFile(srcPath, dstPath);
        fs.close();

    }



    /** @description : 获取某个文件 */
    public static void getFile() throws Exception{
        FileSystem fs = getFileSystem();
        Path srcPath = new Path("test3.hdfsTest://hy:9000/hy/weibo/temp.jar");
        Path dstPath = new Path("D://");
        fs.copyToLocalFile(srcPath, dstPath);
        fs.close();
    }




    /** @description : 获取HDFS节点信息 */
    public static void getHDFSNodes() throws Exception{
        FileSystem fs = getFileSystem();
        DistributedFileSystem hdfs = (DistributedFileSystem)fs;
        DatanodeInfo[] dataNodeStats = hdfs.getDataNodeStats();
        for (int i = 0; i < dataNodeStats.length; i++) {
            System.out.println("DataNote_" + i + "_Name:" + dataNodeStats[i].getHostName());
        }
        fs.close();
    }


    /** @description : 或者本地文件 */
    public static void getFileLocal() throws Exception{
        FileSystem fs = getFileSystem();
        Path path = new Path("test3.hdfsTest://hy:9000/hy/weibo/temp.jar");
        FileStatus fileStatus = fs.getFileStatus(path);
        BlockLocation[] blockLocations = fs.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
        for (int i = 0; i < blockLocations.length; i++) {
            String[] hosts = blockLocations[i].getHosts();
            System.out.println("block_" + i + "_location:" + hosts[0]);
        }
        fs.close();
    }

}
