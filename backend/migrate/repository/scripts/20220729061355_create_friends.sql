-- // create_friends
-- Migration SQL that makes the change goes here.
create table break_up_ledger.friend
(
    id bigserial,
    left_user_id bigint not null,
    right_user_id bigint not null,
    update_time timestamp default now() not null,
    create_time timestamp default now() not null
);

create unique index friend_id_uindex
    on break_up_ledger.friend (id);

-- 索引
alter table break_up_ledger.friend
    add constraint friend_pk
        primary key (id);

alter table break_up_ledger.friend
    add constraint friend_pk_2
        unique (left_user_id);

alter table break_up_ledger.friend
    add constraint friend_pk_3
        unique (right_user_id);

alter table break_up_ledger.friend
    add constraint friend_pk_4
        unique (left_user_id, right_user_id);

CREATE TRIGGER update_time
    BEFORE UPDATE
    ON break_up_ledger.friend
    FOR EACH ROW
EXECUTE PROCEDURE break_up_ledger.update_timestamp();

-- //@UNDO
-- SQL to undo the change goes here.
drop table break_up_ledger.friend;



