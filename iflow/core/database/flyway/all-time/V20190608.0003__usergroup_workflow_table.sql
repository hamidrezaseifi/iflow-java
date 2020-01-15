

DROP TABLE IF EXISTS company_workflow_type;

DROP TABLE IF EXISTS workflow_files_versions;

DROP TABLE IF EXISTS workflow_files;

DROP TABLE IF EXISTS workflow_actions;

DROP TABLE IF EXISTS workflow;

DROP TABLE IF EXISTS workflow_type_step;

DROP TABLE IF EXISTS workflow_type;

DROP TABLE IF EXISTS user_usergroup;

DROP TABLE IF EXISTS user_deputy;

DROP TABLE IF EXISTS user_department_groups;

DROP TABLE IF EXISTS user_departments;

DROP TABLE IF EXISTS departments_group;

DROP TABLE IF EXISTS departments;

DROP TABLE IF EXISTS user_group;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS companies;

DROP TABLE IF EXISTS user_roles;

DROP SEQUENCE IF EXISTS companies_id_seq;

CREATE SEQUENCE companies_id_seq;
  
CREATE TABLE companies (
  id bigint NOT NULL DEFAULT nextval('companies_id_seq'),
  identity varchar(45) DEFAULT NULL,
  company_name varchar(45) NOT NULL,
  status smallint NOT NULL DEFAULT 1,
  version integer NOT NULL DEFAULT 1,
  created_at timestamp without time zone default (now() at time zone 'utc'),
  updated_at timestamp without time zone default (now() at time zone 'utc'),
  PRIMARY KEY (id)
);

CREATE SEQUENCE departments_id_seq;

CREATE TABLE departments (
  id bigint NOT NULL DEFAULT nextval('departments_id_seq'),
  identity varchar(45) DEFAULT NULL,
  company_id bigint NOT NULL DEFAULT '1',
  title varchar(200) NOT NULL,
  status smallint NOT NULL DEFAULT '1',
  version integer NOT NULL DEFAULT '1',
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (id),
  KEY FK_DEPARTMENTS_COMPANY_idx (company_id),
  UNIQUE KEY identity_UNIQUE (identity),
  CONSTRAINT FK_DEPARTMENTS_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE ON UPDATE CASCADE
);


 
CREATE TABLE departments_group (
  id bigint NOT NULL AUTO_INCREMENT,
  identity varchar(45) DEFAULT NULL,
  department_id bigint NOT NULL,
  title varchar(200) NOT NULL,
  status smallint NOT NULL DEFAULT '1',
  version integer NOT NULL DEFAULT '1',
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (id),
  UNIQUE KEY identity_UNIQUE (identity),
  KEY FK_DEPARTMENTGROUP_DEPARTMENT_idx (department_id),
  CONSTRAINT FK_DEPARTMENTGROUP_DEPARTMENT FOREIGN KEY (department_id) REFERENCES departments (id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE iflow_roles (
  id bigint NOT NULL AUTO_INCREMENT,
  title varchar(200) NOT NULL,
  status smallint NOT NULL DEFAULT '1',
  version integer NOT NULL DEFAULT '1',
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (id)
) ;
 

CREATE TABLE users (
  id bigint NOT NULL AUTO_INCREMENT,
  company_id bigint NOT NULL DEFAULT '1',
  email varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  birthdate date DEFAULT NULL,
  password varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '-',
  firstname varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  lastname varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  permission smallint NOT NULL DEFAULT '1',
  status smallint NOT NULL DEFAULT '1',
  version integer NOT NULL DEFAULT '1',
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (id),
  UNIQUE KEY email (email),
  KEY FK_USERS_COMPANIES_idx (company_id),
  CONSTRAINT FK_USERS_COMPANIES FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;
 
CREATE TABLE user_group (
  id bigint NOT NULL AUTO_INCREMENT,
  identity varchar(45) DEFAULT NULL,
  title varchar(200) NOT NULL,
  company_id bigint NOT NULL DEFAULT '1',
  status smallint NOT NULL DEFAULT '1',
  version integer NOT NULL DEFAULT '1',
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (id),
  UNIQUE KEY identity_UNIQUE (identity),
  KEY FK_USERGROUP_COMPANY_idx (company_id),
  CONSTRAINT FK_USERGROUP_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE user_deputy (
  user_id bigint NOT NULL,
  deputy_id bigint NOT NULL,
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (user_id,deputy_id),
  KEY FK_USERDEPUTY_DEPUTY_idx (deputy_id),
  CONSTRAINT FK_USERDEPUTY_DEPUTY FOREIGN KEY (deputy_id) REFERENCES users (id),
  CONSTRAINT FK_USERDEPUTY_USER FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE user_departments (
  user_id bigint NOT NULL,
  department_id bigint NOT NULL,
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (user_id,department_id),
  KEY FK_USERDEPARTMENTS_DEPARTMENTS_idx (department_id),
  CONSTRAINT FK_USERDEPARTMENTS_DEPARTMENTS FOREIGN KEY (department_id) REFERENCES departments (id),
  CONSTRAINT FK_USERDEPARTMENTS_USERS FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE user_department_groups (
  user_id bigint NOT NULL,
  department_group_id bigint NOT NULL,
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (user_id,department_group_id),
  KEY FK_USERDEPARTMENTGROUPS_D_idx (department_group_id),
  CONSTRAINT FK_USERDEPARTMENTGROUPS_D FOREIGN KEY (department_group_id) REFERENCES departments_group (id),
  CONSTRAINT FK_USERDEPARTMENTGROUPS_USERS FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE user_usergroup (
  user_id bigint NOT NULL,
  user_group bigint NOT NULL,
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (user_id,user_group),
  KEY FK_USERGROUPUSER_GROUP_idx (user_group),
  CONSTRAINT FK_USERGROUPUSER_GROUP FOREIGN KEY (user_group) REFERENCES user_group (id),
  CONSTRAINT FK_USERGROUPUSER_USER FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;


CREATE TABLE user_roles (
  user_id bigint NOT NULL,
  role bigint NOT NULL,
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (user_id,role),
  KEY FK_USERROLES_ROLE_idx (role),
  CONSTRAINT FK_USERROLES_ROLE FOREIGN KEY (role) REFERENCES iflow_roles (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_USERROLES_USERS FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;


CREATE TABLE workflow_type (
  id bigint NOT NULL AUTO_INCREMENT,
  identity varchar(45) DEFAULT NULL,
  title varchar(200) NOT NULL,
  assign_type SMALLINT(2) NOT NULL DEFAULT 1,
  send_to_controller smallint(2) NOT NULL DEFAULT '1',
  increase_step_automatic smallint(2) DEFAULT '0',
  allow_assign smallint(2) DEFAULT '0',
  commecnts text,
  status smallint NOT NULL DEFAULT '1',
  version integer NOT NULL DEFAULT '1',
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (id),
  UNIQUE KEY identity_UNIQUE (identity)
);

 
CREATE TABLE workflow_type_step (
  id bigint NOT NULL AUTO_INCREMENT,
  identity varchar(45) DEFAULT NULL,
  workflow_type_id bigint NOT NULL,
  title varchar(200) NOT NULL,
  step_index smallint NOT NULL DEFAULT 0,
  view_name varchar(150) NOT NULL DEFAULT '-',
  expire_days smallint NOT NULL,
  commecnts text,
  status smallint NOT NULL DEFAULT '1',
  version integer NOT NULL DEFAULT '1',
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (id),
  UNIQUE KEY identity_UNIQUE (identity),
  KEY FK_WORKFLOWTYPESTEP_WORKFLOWTYPE_idx (workflow_type_id),
  CONSTRAINT FK_WORKFLOWTYPESTEP_WORKFLOWTYPE FOREIGN KEY (workflow_type_id) REFERENCES workflow_type (id) ON DELETE CASCADE ON UPDATE CASCADE
);

 
CREATE TABLE workflow (
  id bigint NOT NULL AUTO_INCREMENT,
  company_id bigint NOT NULL,
  identity varchar(45) DEFAULT NULL,
  workflow_type_id bigint NOT NULL,
  current_step bigint NOT NULL,
  status bigint NOT NULL,
  comments text,
  controller bigint NOT NULL,
  created_by bigint DEFAULT NULL,
  version integer NOT NULL DEFAULT '1',
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (id),
  UNIQUE KEY identity_UNIQUE (identity),
  KEY FK_WORKFLOW_WORKFLOWTYPE_idx (workflow_type_id),
  KEY FK_WORKFLOW_WORKFLOWTYPESTEP_idx (current_step),
  KEY FK_WORKFLOW_USERS_idx (created_by),
  KEY FK_WORKFLOW_COMPANY_idx (company_id),
  CONSTRAINT FK_WORKFLOW_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_WORKFLOW_USERS FOREIGN KEY (created_by) REFERENCES users (id) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT FK_WORKFLOW_WORKFLOWTYPE FOREIGN KEY (workflow_type_id) REFERENCES workflow_type (id) ON UPDATE CASCADE,
  CONSTRAINT FK_WORKFLOW_WORKFLOWTYPESTEP FOREIGN KEY (current_step) REFERENCES workflow_type_step (id) ON UPDATE CASCADE
);
 
CREATE TABLE workflow_actions (
  id bigint NOT NULL AUTO_INCREMENT,
  workflow_id bigint NOT NULL,
  assign_to bigint NOT NULL DEFAULT '0',
  current_step_id bigint NOT NULL DEFAULT '0',
  comments varchar(45) DEFAULT NULL,
  status bigint DEFAULT '1',
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (id),
  KEY FK_WORKFLOWACTION_WORKFLOW_idx (workflow_id),
  CONSTRAINT FK_WORKFLOWACTION_WORKFLOW FOREIGN KEY (workflow_id) REFERENCES workflow (id) ON UPDATE CASCADE
);

 
CREATE TABLE workflow_files (
  id bigint NOT NULL AUTO_INCREMENT,
  identity varchar(45) DEFAULT NULL,
  workflow_id bigint NOT NULL,
  title varchar(200) NOT NULL,
  extention varchar(10) NOT NULL,
  active_filepath varchar(500) NOT NULL,
  comments text,
  active_version integer NOT NULL DEFAULT '1',
  status smallint NOT NULL DEFAULT '1',
  created_by bigint DEFAULT NULL,
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (id),
  UNIQUE KEY identity_UNIQUE (identity),
  KEY FK_WORKFLOWFILE_WORKFLOW_idx (workflow_id),
  KEY FK_WORKFLOWFILE_USERS_idx (created_by),
  CONSTRAINT FK_WORKFLOWFILE_USERS FOREIGN KEY (created_by) REFERENCES users (id) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT FK_WORKFLOWFILE_WORKFLOW FOREIGN KEY (workflow_id) REFERENCES workflow (id) ON UPDATE CASCADE
);

 

CREATE TABLE workflow_files_versions (
  id bigint NOT NULL AUTO_INCREMENT,
  workflow_file_id bigint NOT NULL,
  filepath varchar(500) NOT NULL,
  comments text,
  file_version integer NOT NULL DEFAULT '1',
  status smallint NOT NULL DEFAULT '1',
  created_by bigint DEFAULT NULL,
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (id),
  KEY FK_WORKFLOWFILEVERSION_WORKFLOWFILE_idx (workflow_file_id),
  CONSTRAINT FK_WORKFLOWFILEVERSION_WORKFLOWFILE FOREIGN KEY (workflow_file_id) REFERENCES workflow_files (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE company_workflow_type (
  company_id bigint NOT NULL,
  workflow_type_id bigint NOT NULL,
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (company_id,workflow_type_id),
  KEY FK_COMPANYWORKFLOWTYPE_WORKFLOWTYPE_idx (workflow_type_id),
  CONSTRAINT FK_COMPANYWORKFLOWTYPE_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_COMPANYWORKFLOWTYPE_WORKFLOWTYPE FOREIGN KEY (workflow_type_id) REFERENCES workflow_type (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

