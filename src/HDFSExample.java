import org.apache.hadoop.conf.Configuration; // 负责管理相关配置文件
import org.apache.hadoop.fs.FileSystem; // 抽象基类,所有读写操作继承自此抽象基类
import org.apache.hadoop.fs.Path; // URI格式

public class HDFSExample {
    public static void main(String[] args) {
        try {
            String fileName = "hdfs://localhost:9000/user/hadoop/test.txt"; // linux文件以二进制保存,可以不加.txt
            Configuration conf = new Configuration(); // 生成配置环境参数对象
            conf.set("fs.defaultFS", "hdfs://localhost:9000");
            conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
            FileSystem fs = FileSystem.get(conf); // 实例化文件系统FileSystem对象
            if (fs.exists(new Path(fileName))) {
                System.out.println("文件存在");
            } else {
                System.out.println("文件不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}