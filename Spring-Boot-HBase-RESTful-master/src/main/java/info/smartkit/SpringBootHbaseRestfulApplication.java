package info.smartkit;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import info.smartkit.data.hadoop.hbase.User;
import info.smartkit.data.hadoop.hbase.UserRepository;
import info.smartkit.data.hadoop.hbase.UserUtils;

@SpringBootApplication
public class SpringBootHbaseRestfulApplication {

	private static final Log log = LogFactory.getLog(SpringBootHbaseRestfulApplication.class);

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/application-context.xml", SpringBootHbaseRestfulApplication.class);
		log.info("HBase Application Running");
		context.registerShutdownHook();

//		Configuration hbaseConf = HBaseConfiguration.create();
//		hbaseConf.set(HConstants.ZOOKEEPER_QUORUM,"localhost");

		UserUtils userUtils = context.getBean(UserUtils.class);
		userUtils.initialize();
		userUtils.addUsers();

		UserRepository userRepository = context.getBean(UserRepository.class);
		List<User> users = userRepository.findAll();
		System.out.println("Number of users = " + users.size());
		System.out.println(users);
	}
}
