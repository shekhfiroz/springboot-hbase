package com.is.cw.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.data.hbase")
public class HbaseProperties {
	/* Addresses of all registered ZK servers. */
	private String zkQuorum;

	/* Location of HBase home directory */
	private String rootDir;

	/* to get Root node of this cluster in ZK. */
	private String zkBasePath;

	public String getZkQuorum() {
		return zkQuorum;
	}

	public void setZkQuorum(String zkQuorum) {
		this.zkQuorum = zkQuorum;
	}

	public String getRootDir() {
		return rootDir;
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	public String getZkBasePath() {
		return zkBasePath;
	}

	public void setZkBasePath(String zkBasePath) {
		this.zkBasePath = zkBasePath;
	}

}
