drop sequence if exists "twitter_message_seq";

create sequence "twitter_message_seq"
start with 1;

drop table if exists "twitter_message";

create table "twitter_message" (
"id" int default nextval('twitter_message_seq') primary key,
"user" text,
"text" text,
"created_date" timestamp default current_timestamp
);
