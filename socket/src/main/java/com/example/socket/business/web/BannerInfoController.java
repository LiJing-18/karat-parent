package com.example.socket.business.web;

import com.example.socket.business.ResponseVo;
import com.example.socket.business.BaseController;
import com.example.socket.business.dto.arg.BannerInfoInsert;
import com.example.socket.business.dto.arg.BannerInfoSearch;
import com.example.socket.business.dto.arg.BannerInfoUpdate;
import com.example.socket.business.dto.vo.BannerInfoVo;
import com.example.socket.business.service.BannerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import javax.annotation.Resource;

/**
 * Banner信息Controller
 * @author L
 * @Date 2019-12-30 14:16:29
 */
@RestController
@RequestMapping("/bannerInfo")
@Api(tags = "Banner信息", description = "Banner信息", produces= MediaType.APPLICATION_JSON_VALUE)
public class BannerInfoController extends BaseController {

    private final String PREFIX = "/bannerInfo/";
    private final String CN_PREFIX = "Banner信息";

    @Resource
    private BannerInfoService bannerInfoService;

    /**
     * 分页查询
     * @param bannerInfoSearch
     * @url /bannerInfo/page
     * @return
     */
    @GetMapping(value = "page")
    @ApiOperation(value = page_Ch, httpMethod = "GET", notes = "")
    public ResponseVo<List<BannerInfoVo>> page(@Valid BannerInfoSearch bannerInfoSearch) {
        return null;
    }

    /**
     * 列表查询
     * @param bannerInfoSearch
     * @url /bannerInfo/list
     * @return
     */
    @GetMapping(value = list)
    @ApiOperation(value = list_Ch, httpMethod = GET, notes = auth_yes)
    public ResponseVo<List<BannerInfoVo>> list(@Valid BannerInfoSearch bannerInfoSearch) {
        return null;
    }

    /**
     * 单条查询
     * @param id
     * @url /bannerInfo/single
     * @return
     */
    @GetMapping(value = single)
    @ApiOperation(value = single_Ch, httpMethod = GET, notes = auth_yes)
    public ResponseVo<BannerInfoVo> single(String id){
        return null;
    }

    /**
     * 新增
     * @param bannerInfoInsert
     * @url /bannerInfo/add
     * @return
     */
    @PostMapping(value = add)
    @ApiOperation(value = add_Ch, httpMethod = POST, notes = auth_yes)
    public ResponseVo<Integer> add(@RequestBody @Valid BannerInfoInsert bannerInfoInsert){
        return null;
    }

    /**
     * 修改
     * @param bannerInfoUpdate
     * @url /bannerInfo/update
     * @return
     */
    @PostMapping(value = update)
    @ApiOperation(value = update_Ch, httpMethod = POST, notes = auth_yes)
    public ResponseVo<Integer> update(@RequestBody @Valid BannerInfoUpdate bannerInfoUpdate){
        return null;
    }

    /**
     * 删除
     * @param id
     * @url /bannerInfo/delete
     * @return
     */
    @PostMapping(value = delete)
    @ApiOperation(value = delete_Ch, httpMethod = POST, notes = auth_yes)
    public ResponseVo<Integer> delete(String id){
        return null;
    }

}
