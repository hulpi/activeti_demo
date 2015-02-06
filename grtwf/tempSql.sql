select * from act_id_user;
select * from act_id_group;
select * from act_id_info;
select * from act_id_membership;

--delete from act_id_info;
--delete from act_id_membership;
--delete from act_id_user;
--delete from act_id_group;

SELECT * FROM ACT_HI_ACTINST 
SELECT * FROM ACT_HI_IDENTITYLINK 
SELECT * FROM ACT_HI_PROCINST 
SELECT * FROM ACT_HI_TASKINST 
SELECT * FROM ACT_HI_VARINST 

SELECT * FROM ACT_RU_EXECUTION t where t.proc_inst_id_='101218';
SELECT * FROM ACT_RU_IDENTITYLINK t where t.proc_inst_id_ = '101218';
SELECT * FROM ACT_RU_TASK  t where t.proc_def_id_='approvalProcess:2:76245'
SELECT * FROM ACT_RU_VARIABLE t where t.proc_inst_id_='101218';

--109496
SELECT * FROM ACT_RU_EXECUTION t where t.proc_inst_id_='109496';
SELECT * FROM ACT_RU_IDENTITYLINK t where t.proc_inst_id_ = '109496';
SELECT * FROM ACT_RU_TASK  t where t.proc_inst_id_='109496';
SELECT * FROM ACT_RU_VARIABLE t where t.proc_inst_id_='109496';

--111751
SELECT * FROM ACT_RU_EXECUTION t where t.proc_inst_id_ in (
    SELECT t.proc_inst_id_ FROM ACT_RU_TASK  t where t.proc_def_id_='approvalProcess:2:76245');
    
SELECT * FROM ACT_RU_IDENTITYLINK t where t.proc_inst_id_ in (
    SELECT t.proc_inst_id_ FROM ACT_RU_TASK  t where t.proc_def_id_='approvalProcess:2:76245');
    
SELECT * FROM ACT_RU_TASK  t where t.proc_inst_id_ in (
    SELECT t.proc_inst_id_ FROM ACT_RU_TASK  t where t.proc_def_id_ like '%approvalProcess%');
    
SELECT * FROM ACT_RU_VARIABLE t where t.proc_inst_id_ in (
    SELECT t.proc_inst_id_ FROM ACT_RU_TASK  t where t.proc_def_id_='approvalProcess:2:76245');
