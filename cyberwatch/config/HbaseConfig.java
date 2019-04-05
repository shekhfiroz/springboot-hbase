package com.is.cyberwatch.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

@Configuration
@EnableConfigurationProperties(HbaseProperties.class)
public class HbaseConfig {

    @Autowired
    private HbaseProperties hbaseProperties;

    @Bean
    public HbaseTemplate hbaseTemplate() {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", this.hbaseProperties.getZkQuorum());
        configuration.set("hbase.rootdir", this.hbaseProperties.getRootDir());
        configuration.set("zookeeper.znode.parent", this.hbaseProperties.getZkBasePath());
        return new HbaseTemplate(configuration);
    }

}
