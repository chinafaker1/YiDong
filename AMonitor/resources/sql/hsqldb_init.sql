create cached table acl_resource (id varchar(32) not null, list integer, logo_pic varchar(255), menu_id varchar(255), menu_type varchar(10) not null, name varchar(200) not null, type_code varchar(10) not null, url varchar(200) not null,request_method varchar(10) not null, primary key (id), unique (url,request_method));
create cached table cron_exclusive_task (id varchar(200) not null, running bit not null, update_time timestamp not null, node_tag varchar(100), md5 varchar(50) not null, primary key (id));
create cached table acl_role (id varchar(32) not null, info varchar(255), list integer not null, name varchar(200) not null, system bit not null, primary key (id))
create cached table acl_role_resource (id varchar(32) not null, resource_id varchar(32) not null, role_id varchar(32) not null, primary key (id))
create cached table acl_user (id varchar(32) not null, email varchar(50), fax varchar(50), login_name varchar(100) not null, male bit not null, mobile varchar(50), name varchar(200) not null, name_py varchar(200) not null, passwd varchar(50) not null, status varchar(10) not null, tel varchar(50), role_id varchar(32) not null, primary key (id), unique (login_name))
create cached table system_info (id varchar(32) not null, conf_type varchar(20) not null, user_id varchar(32) not null,json_str varchar(4000) not null, primary key (id),unique (conf_type,user_id))
create cached table system_log (id varchar(32) not null, info varchar(255) not null, ip varchar(20) not null, log_type varchar(10) not null, optime timestamp not null, user_id varchar(32), primary key (id))
create cached table schedule_log (id varchar(32) not null, by_system boolean not null, current_cron varchar(50) not null, end_time timestamp not null, start_time timestamp not null, task_name varchar(100) not null, exec_time bigint not null,primary key (id))
alter table acl_role_resource add constraint FK348A2AC26F466CC foreign key (role_id) references acl_role
alter table acl_role_resource add constraint FK348A2AC21544FB29 foreign key (resource_id) references acl_resource
alter table acl_user add constraint FK8F17F2606F466CC foreign key (role_id) references acl_role
alter table system_log add constraint FK26569534AC1F2AAC foreign key (user_id) references acl_user

