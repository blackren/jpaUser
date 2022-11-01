package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class user extends BaseEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, unique = true)
  @NotEmpty(message = "使用者名稱不得為空")
  private String username;

  @Column(nullable = false, unique = true)
  @NotEmpty(message = "email不得為空")
  private String email;

  @Column(nullable = false, unique = true)
  @NotEmpty(message = "password不得為空")
  private String password;

  /*
   * @Column(nullable = false)
   * private String body;
   */

}
