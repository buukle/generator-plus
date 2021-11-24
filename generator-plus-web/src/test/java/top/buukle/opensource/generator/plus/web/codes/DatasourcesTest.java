package top.buukle.opensource.generator.plus.web.codes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.buukle.opensource.generator.plus.commons.call.CommonRequest;
import top.buukle.opensource.generator.plus.commons.call.CommonResponse;
import top.buukle.opensource.generator.plus.commons.call.PageResponse;
import top.buukle.opensource.generator.plus.utils.JsonUtil;
import top.buukle.opensource.generator.plus.dtvo.dto.datasources.DatasourcesQueryDTO;
import top.buukle.opensource.generator.plus.dtvo.dto.datasources.DatasourcesUpdateDTO;
import top.buukle.opensource.generator.plus.service.DatasourcesService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourcesTest {

    @Autowired
    DatasourcesService datasourcesService;

    /**
     * @description 增
     * @param
     * @return void
     * @Author zhanglei001
     * @Date 2021/9/15
     */
    @Test
    public void datasourcesAdd_test() {

        CommonRequest<DatasourcesUpdateDTO> datasourcesQueryDTOCommonRequest = new CommonRequest();
        DatasourcesUpdateDTO datasourcesUpdateDTO = new DatasourcesUpdateDTO();
        datasourcesUpdateDTO.setName("name");
        datasourcesUpdateDTO.setRemark("remark");
        datasourcesQueryDTOCommonRequest.setBody(datasourcesUpdateDTO);
        CommonResponse commonResponse = datasourcesService.add(datasourcesQueryDTOCommonRequest);

        System.out.println(JsonUtil.toJSONString(commonResponse));
    }

    /**
     * @description 删
     * @param
     * @return void
     * @Author zhanglei001
     * @Date 2021/9/15
     */
    @Test
    public void datasourcesDeleteById_test() {

        CommonRequest<DatasourcesUpdateDTO> datasourcesQueryDTOCommonRequest = new CommonRequest();
        DatasourcesUpdateDTO datasourcesUpdateDTO = new DatasourcesUpdateDTO();
        datasourcesUpdateDTO.setId(599);
        datasourcesQueryDTOCommonRequest.setBody(datasourcesUpdateDTO);
        CommonResponse commonResponse = datasourcesService.deleteById(datasourcesQueryDTOCommonRequest);

        System.out.println(JsonUtil.toJSONString(commonResponse));
    }

    /**
     * @description 改
     * @param
     * @return void
     * @Author zhanglei001
     * @Date 2021/9/15
     */
    @Test
    public void datasourcesUpdateById_test() {

        CommonRequest<DatasourcesUpdateDTO> datasourcesQueryDTOCommonRequest = new CommonRequest();
        DatasourcesUpdateDTO datasourcesUpdateDTO = new DatasourcesUpdateDTO();
        datasourcesUpdateDTO.setId(6002);
        datasourcesUpdateDTO.setName("name-6002");
        datasourcesQueryDTOCommonRequest.setBody(datasourcesUpdateDTO);
        CommonResponse commonResponse = datasourcesService.updateById(datasourcesQueryDTOCommonRequest);

        System.out.println(JsonUtil.toJSONString(commonResponse));
    }

    /**
     * @description 查 - 单条
     * @param
     * @return void
     * @Author zhanglei001
     * @Date 2021/9/15
     */
    @Test
    public void datasourcesGetById_test() {

        CommonRequest<DatasourcesQueryDTO> datasourcesQueryDTOCommonRequest = new CommonRequest();
        DatasourcesQueryDTO datasourcesQueryDTO = new DatasourcesQueryDTO();
        datasourcesQueryDTO.setId(602);
        datasourcesQueryDTOCommonRequest.setBody(datasourcesQueryDTO);
        CommonResponse commonResponse = datasourcesService.getById(datasourcesQueryDTOCommonRequest);

        System.out.println(JsonUtil.toJSONString(commonResponse));
    }

    /**
     * @description 查 - 分页
     * @param
     * @return void
     * @Author zhanglei001
     * @Date 2021/9/15
     */
    @Test
    public void datasourcesGetPage_test() {

        CommonRequest<DatasourcesQueryDTO> datasourcesQueryDTOCommonRequest = new CommonRequest();
        DatasourcesQueryDTO datasourcesQueryDTO = new DatasourcesQueryDTO();
        datasourcesQueryDTO.setPageNo(4);
        datasourcesQueryDTOCommonRequest.setBody(datasourcesQueryDTO);
        PageResponse page = datasourcesService.getPage(datasourcesQueryDTOCommonRequest);

        System.out.println(JsonUtil.toJSONString(page));
    }
}
