package com.mybatisplus.first.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @TableId(type=IdType.AUTO)
  private Long id;
  private String name;
  private Integer age;
  private String email;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @Version  //乐观锁注解
  private Integer version;
  @TableLogic //逻辑删除
  private Integer deleted;

}


