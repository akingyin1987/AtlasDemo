package com.taobao.firstbundle.db;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @ Description:
 * @ Author king
 * @ Date 2017/8/21 15:35
 * @ Version V1.0
 */

@Entity(nameInDb = "tb_user")
public class UserEntity implements Serializable{

  private static final long serialVersionUID = 6872263685752044243L;

  @Id(autoincrement = true)
  private    Long   userId;


  @Property(nameInDb = "name")
  private    String   name;

  @Property(nameInDb = "age")
  private   int    age;

  @Generated(hash = 1666315046)
  public UserEntity(Long userId, String name, int age) {
      this.userId = userId;
      this.name = name;
      this.age = age;
  }

  @Generated(hash = 1433178141)
  public UserEntity() {
  }

  public Long getUserId() {
      return this.userId;
  }

  public void setUserId(Long userId) {
      this.userId = userId;
  }

  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public int getAge() {
      return this.age;
  }

  public void setAge(int age) {
      this.age = age;
  }
}
