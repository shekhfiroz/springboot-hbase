package com.is.cyberwatch.dao;

import java.util.List;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.stereotype.Repository;

import com.is.cyberwatch.entity.User;

@Repository
public class UserRepository {

	@Autowired
	private HbaseTemplate hbaseTemplate;

	private String tableName = "users";

	public static byte[] CF_INFO = Bytes.toBytes("cfInfo");

	private byte[] qUser = Bytes.toBytes("user");
	private byte[] qEmail = Bytes.toBytes("email");
	private byte[] qPassword = Bytes.toBytes("password");

	public List<User> findAll() {
		return hbaseTemplate.find(tableName, "cfInfo", new RowMapper<User>() {
			@Override
			public User mapRow(Result result, int rowNum) throws Exception {
				return new User(Bytes.toString(result.getValue(CF_INFO, qUser)),
						Bytes.toString(result.getValue(CF_INFO, qEmail)),
						Bytes.toString(result.getValue(CF_INFO, qPassword)));
			}
		});
	}
}