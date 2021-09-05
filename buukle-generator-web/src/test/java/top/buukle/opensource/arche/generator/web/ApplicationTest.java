package top.buukle.opensource.arche.generator.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.buukle.business.base.commons.call.CommonRequest;
import top.buukle.business.base.commons.call.CommonResponse;
import top.buukle.business.base.commons.call.PageResponse;
import top.buukle.opensource.arche.generator.dos.dto.datasources.DatasourcesQueryDTO;
import top.buukle.opensource.arche.generator.dos.dto.datasources.DatasourcesUpdateDTO;
import top.buukle.opensource.arche.generator.service.DatasourcesService;
import top.buukle.business.base.utils.JsonUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    DatasourcesService datasourcesService;

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

    @Test
    public void datasourcesDeleteById_test() {

        CommonRequest<DatasourcesUpdateDTO> datasourcesQueryDTOCommonRequest = new CommonRequest();
        DatasourcesUpdateDTO datasourcesUpdateDTO = new DatasourcesUpdateDTO();
        datasourcesUpdateDTO.setId(599);
        datasourcesQueryDTOCommonRequest.setBody(datasourcesUpdateDTO);
        CommonResponse commonResponse = datasourcesService.deleteById(datasourcesQueryDTOCommonRequest);

        System.out.println(JsonUtil.toJSONString(commonResponse));
    }

    @Test
    public void datasourcesUpdateById_test() {

        CommonRequest<DatasourcesUpdateDTO> datasourcesQueryDTOCommonRequest = new CommonRequest();
        DatasourcesUpdateDTO datasourcesUpdateDTO = new DatasourcesUpdateDTO();
        datasourcesUpdateDTO.setId(600);
        datasourcesUpdateDTO.setName("name-600");
        datasourcesQueryDTOCommonRequest.setBody(datasourcesUpdateDTO);
        CommonResponse commonResponse = datasourcesService.updateById(datasourcesQueryDTOCommonRequest);

        System.out.println(JsonUtil.toJSONString(commonResponse));
    }

    @Test
    public void datasourcesGetById_test() {

        CommonRequest<DatasourcesQueryDTO> datasourcesQueryDTOCommonRequest = new CommonRequest();
        DatasourcesQueryDTO datasourcesQueryDTO = new DatasourcesQueryDTO();
        datasourcesQueryDTO.setId(602);
        datasourcesQueryDTOCommonRequest.setBody(datasourcesQueryDTO);
        CommonResponse commonResponse = datasourcesService.getById(datasourcesQueryDTOCommonRequest);

        System.out.println(JsonUtil.toJSONString(commonResponse));
    }

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
