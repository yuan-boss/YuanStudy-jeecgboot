package org.jeecg.system.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.system.entity.CeshiZhongkrNote;
import org.jeecg.system.service.ICeshiZhongkrNoteService;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 中科请假单
 * @Author: jeecg-boot
 * @Date:   2022-07-25
 * @Version: V1.0
 */
@Api(tags="中科请假单")
@RestController
@RequestMapping("/yuan/ceshiZhongkrNote")
@Slf4j
public class CeshiZhongkrNoteController extends JeecgController<CeshiZhongkrNote, ICeshiZhongkrNoteService> {
	@Autowired
	private ICeshiZhongkrNoteService ceshiZhongkrNoteService;


	 @ApiOperation("你好")
	 @GetMapping("/hello")
	 public String hello(){
		 return "你好啊";
	 }
	/**
	 * 分页列表查询
	 *
	 * @param ceshiZhongkrNote
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */


	//@AutoLog(value = "中科请假单-分页列表查询")
	@ApiOperation(value="中科请假单-分页列表查询", notes="中科请假单-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<CeshiZhongkrNote>> queryPageList(CeshiZhongkrNote ceshiZhongkrNote,
														 @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
														 @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
														 HttpServletRequest req) {
		QueryWrapper<CeshiZhongkrNote> queryWrapper = QueryGenerator.initQueryWrapper(ceshiZhongkrNote, req.getParameterMap());
		Page<CeshiZhongkrNote> page = new Page<CeshiZhongkrNote>(pageNo, pageSize);
		IPage<CeshiZhongkrNote> pageList = ceshiZhongkrNoteService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
	 *   添加
	 *
	 * @param ceshiZhongkrNote
	 * @return
	 */
	@AutoLog(value = "中科请假单-添加")
	@ApiOperation(value="中科请假单-添加", notes="中科请假单-添加")
	//@RequiresPermissions("org.jeecg.modules.demo:ceshi_zhongkr_note:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody CeshiZhongkrNote ceshiZhongkrNote) {
		ceshiZhongkrNoteService.save(ceshiZhongkrNote);
		return Result.OK("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param ceshiZhongkrNote
	 * @return
	 */
	@AutoLog(value = "中科请假单-编辑")
	@ApiOperation(value="中科请假单-编辑", notes="中科请假单-编辑")
	//@RequiresPermissions("org.jeecg.modules.demo:ceshi_zhongkr_note:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody CeshiZhongkrNote ceshiZhongkrNote) {
		ceshiZhongkrNoteService.updateById(ceshiZhongkrNote);
		return Result.OK("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "中科请假单-通过id删除")
	@ApiOperation(value="中科请假单-通过id删除", notes="中科请假单-通过id删除")
	//@RequiresPermissions("org.jeecg.modules.demo:ceshi_zhongkr_note:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		ceshiZhongkrNoteService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "中科请假单-批量删除")
	@ApiOperation(value="中科请假单-批量删除", notes="中科请假单-批量删除")
	//@RequiresPermissions("org.jeecg.modules.demo:ceshi_zhongkr_note:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ceshiZhongkrNoteService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "中科请假单-通过id查询")
	@ApiOperation(value="中科请假单-通过id查询", notes="中科请假单-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<CeshiZhongkrNote> queryById(@RequestParam(name="id",required=true) String id) {
		CeshiZhongkrNote ceshiZhongkrNote = ceshiZhongkrNoteService.getById(id);
		if(ceshiZhongkrNote==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(ceshiZhongkrNote);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ceshiZhongkrNote
    */
    //@RequiresPermissions("org.jeecg.modules.demo:ceshi_zhongkr_note:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CeshiZhongkrNote ceshiZhongkrNote) {
        return super.exportXls(request, ceshiZhongkrNote, CeshiZhongkrNote.class, "中科请假单");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("ceshi_zhongkr_note:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CeshiZhongkrNote.class);
    }

}
