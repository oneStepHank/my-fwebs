package com.archive.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnectionTest {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try (InputStream input = DBConnectionTest.class.getClassLoader().getResourceAsStream("db.properties")) {
            // 1. 설정 파일 로드
            prop.load(input);

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.username");
            String pass = prop.getProperty("db.password");

            // 2. DB 연결 시도
            Connection conn = DriverManager.getConnection(url, user, pass);

            if (conn != null) {
                System.out.println("✅ MariaDB 접속 성공!");
            }
        } catch (Exception e) {
            System.out.println("❌ 접속 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }
}