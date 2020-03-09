package com.pth.iflow.core.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.pth.iflow.core.storage.dao.helper.EntityHelper;
import com.pth.iflow.core.storage.dao.helper.EntityListener;

@Entity
@Table(name = "user_dashboard_menus")
@EntityListeners(EntityListener.class)
public class UserDashboardMenuEntity extends EntityHelper {

  private static final long serialVersionUID = 2937568589389217869L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_dashboard_menus_seq_generator")
  @SequenceGenerator(
                     name = "user_dashboard_menus_seq_generator", allocationSize = 1, initialValue = 1, sequenceName = "user_dashboard_menus_seq"
  )
  private Long id;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "menu_id")
  private String menuId;

  @Column(name = "row_index")
  private Integer rowIndex;

  @Column(name = "column_index")
  private Integer columnIndex;

  @Column(name = "status")
  private Integer status;

  @Column(name = "version")
  private Integer version;

  @CreationTimestamp
  @Column(name = "created_at", insertable = false, updatable = false)
  private Date createdAt;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  private UserEntity user;

  @Override
  public Long getId() {

    return id;
  }

  @Override
  public void setId(final Long id) {

    this.id = id;
  }

  public Long getUserId() {

    return userId;
  }

  public void setUserId(final Long userId) {

    this.userId = userId;
  }

  public String getMenuId() {

    return menuId;
  }

  public void setMenuId(final String menuId) {

    this.menuId = menuId;
  }

  public Integer getRowIndex() {

    return rowIndex;
  }

  public void setRowIndex(final Integer rowIndex) {

    this.rowIndex = rowIndex;
  }

  public Integer getColumnIndex() {

    return columnIndex;
  }

  public void setColumnIndex(final Integer columnIndex) {

    this.columnIndex = columnIndex;
  }

  public Integer getStatus() {

    return status;
  }

  public void setStatus(final Integer status) {

    this.status = status;
  }

  @Override
  public Integer getVersion() {

    return version;
  }

  @Override
  public void setVersion(final Integer version) {

    this.version = version;
  }

  public Date getCreatedAt() {

    return createdAt;
  }

  public void setCreatedAt(final Date createdAt) {

    this.createdAt = createdAt;
  }

  @Override
  public void increaseVersion() {

    version += 1;
  }
}
