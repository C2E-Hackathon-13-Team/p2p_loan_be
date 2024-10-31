CREATE TABLE public.launcher (
    address varchar NULL,
    uname varchar NULL,
    create_time timestamp NULL,
    update_time timestamp NULL,
    CONSTRAINT launcher_pk PRIMARY KEY (address)
);

-- Column comments
COMMENT ON COLUMN public.launcher.address IS '地址';
COMMENT ON COLUMN public.launcher.uname IS '姓名';
COMMENT ON COLUMN public.launcher.create_time IS '创建时间';
COMMENT ON COLUMN public.launcher.update_time IS '更新时间';

