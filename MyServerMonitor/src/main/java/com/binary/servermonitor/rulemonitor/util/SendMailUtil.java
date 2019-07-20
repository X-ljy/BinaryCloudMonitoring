package com.binary.servermonitor.rulemonitor.util;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class SendMailUtil {

    public static String charset = "UTF-8";
    public static void sendMail(String email,String title,String messages) throws AddressException, MessagingException, UnsupportedEncodingException {
        Properties properties = new Properties();
        // 连接协议
        properties.put("mail.transport.protocol", "smtp");
        // 主机名
        properties.put("mail.smtp.host", "10.10.44.128");
        // 端口号
        properties.put("mail.smtp.port", 25);
        properties.put("mail.smtp.auth", "true");
        // 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.smtp.ssl.enable", "false");
        // 设置是否显示debug信息 true 会在控制台显示相关信息
        properties.put("mail.debug", "true");
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("727789136@binary.com"));
        // 设置收件人邮箱地址
        System.setProperty("mail.mime.charset","UTF-8");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        // 设置邮件标题
        message.setSubject(MimeUtility.encodeText(title,"UTF-8","B"));
        // 设置邮件内容
        Multipart mp;
        mp = new MimeMultipart();
        BodyPart bp = new MimeBodyPart();
        bp.setContent(messages, "text/html;charset=utf-8");
        mp.addBodyPart(bp);
        message.setContent(mp,"text/html;charset=UTF-8");
        message.saveChanges();
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        // 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        transport.connect("727789136@binary.com", "123456789");
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
