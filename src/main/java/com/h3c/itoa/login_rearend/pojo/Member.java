package com.h3c.itoa.login_rearend.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@PropertySource(value = {"classpath:member.properties"})
//@ConfigurationProperties(prefix = "member")
public class Member {
    @Value("#{T(java.lang.Integer).parseInt('${member.id}')}")
    private Integer id;
    @Value("${member.account}")
    private String account;
    @Value("member.remark")
    private String remark;
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
