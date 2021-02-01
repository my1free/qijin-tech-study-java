package tech.qijin.study.transaction.mysql.db2.model;

import java.util.Date;

public class User2 {
    private Integer id;
    private String name;
    private Integer age;
    private Date ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User1{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", ctime=").append(ctime);
        sb.append('}');
        return sb.toString();
    }
}
