package com.example.socket.business;

public class BaseController {

    protected static final String add = "add";
    protected static final String add_Ch = "新增";
    protected static final String update = "update";
    protected static final String update_Ch = "修改";
    protected static final String delete = "delete";
    protected static final String delete_Ch = "删除";
    protected static final String single = "single";
    protected static final String single_Ch = "查询单条";
    protected static final String list = "list";
    protected static final String list_Ch = "列表查询";
    protected static final String page = "page";
    protected static final String page_Ch = "分页查询";
    protected static final int log_insert = 1;
    protected static final int log_update = 2;
    protected static final int log_delete = 3;
    protected static final int log_select = 4;
    protected static final String auth_yes = "鉴权: 是";
    protected static final String auth_no = "鉴权: 否";
    protected static final String POST = "POST";
    protected static final String GET = "GET";

    public BaseController() {
    }

}
