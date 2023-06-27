package com.production.erp.converter;

import com.production.erp.entity.TestingEntity;
import com.production.erp.model.TestingModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestingConverter {
    public TestingModel toModel(TestingEntity entity){
        TestingModel model = new TestingModel();
        model.setDate(entity.getDate());
        model.setId(entity.getId());
        model.setImei(entity.getImei());
        model.setiOS(entity.getiOS());
        model.setOperator(entity.getOperator());
        model.setTL0(entity.isTL0());
        model.setTL1(entity.isTL1());
        model.setTL2(entity.isTL2());
        model.setTL2T(entity.isTL2T());
        model.setTL4(entity.isTL4());
        model.setTL5(entity.isTL5());
        model.setTL5A(entity.isTL5A());
        model.setTL5B(entity.isTL5B());
        model.setTL8(entity.isTL8());
        model.setTL8P(entity.isTL8P());
        model.setTL9(entity.isTL9());
        model.setTL9T(entity.isTL9T());
        model.setTL10(entity.isTL10());
        model.setTL10G(entity.isTL10G());
        model.setTL10T(entity.isTL10T());
        model.setTL11(entity.isTL11());
        model.setTL11G(entity.isTL11G());
        model.setTL12(entity.isTL12());
        model.setTL13(entity.isTL13());
        model.setTL14(entity.isTL14());
        model.setTL14A(entity.isTL14A());
        model.setTL14B(entity.isTL14B());
        model.setTL14P(entity.isTL14P());
        model.setTL14T(entity.isTL14T());
        model.setTL16(entity.isTL16());
        model.setTL15(entity.isTL15());
        model.setTL17(entity.isTL17());
        model.setTL18(entity.isTL18());
        model.setTL19(entity.isTL19());
        model.setTL19A(entity.isTL19A());
        model.setTL21(entity.isTL21());
        model.setTL22(entity.isTL22());
        model.setTL22T(entity.isTL22T());
        model.setTL24(entity.isTL24());
        model.setTL26(entity.isTL26());
        model.setTL26T(entity.isTL26T());
        model.setTL27(entity.isTL27());
        model.setTL27T(entity.isTL27T());
        model.setTL28(entity.isTL28());
        model.setTL28T(entity.isTL28T());
        model.setTL29(entity.isTL29());
        model.setTL29A(entity.isTL29A());
        model.setTL29B(entity.isTL29B());
        model.setTL29C(entity.isTL29C());
        model.setTL30(entity.isTL30());
        model.setTL32(entity.isTL32());
        model.setTL36(entity.isTL36());
        model.setTL36T(entity.isTL36T());
        model.setTL37(entity.isTL37());
        model.setTL38(entity.isTL38());
        model.setTL39(entity.isTL39());
        model.setTL40(entity.isTL40());
        model.setTL41(entity.isTL41());
        model.setTL42(entity.isTL42());
        model.setTL42A(entity.isTL42A());
        return model;
    }

    public TestingEntity toEntity(TestingModel model){
        TestingEntity entity = new TestingEntity();
        entity.setDate(model.getDate());
        entity.setId(model.getId());
        entity.setImei(model.getImei());
        entity.setiOS(model.getiOS());
        entity.setOperator(model.getOperator());
        entity.setTL0(model.isTL0());
        entity.setTL1(model.isTL1());
        entity.setTL2(model.isTL2());
        entity.setTL2T(model.isTL2T());
        entity.setTL4(model.isTL4());
        entity.setTL5(model.isTL5());
        entity.setTL5A(model.isTL5A());
        entity.setTL5B(model.isTL5B());
        entity.setTL8(model.isTL8());
        entity.setTL8P(model.isTL8P());
        entity.setTL9(model.isTL9());
        entity.setTL9T(model.isTL9T());
        entity.setTL10(model.isTL10());
        entity.setTL10G(model.isTL10G());
        entity.setTL10T(model.isTL10T());
        entity.setTL11(model.isTL11());
        entity.setTL11G(model.isTL11G());
        entity.setTL12(model.isTL12());
        entity.setTL13(model.isTL13());
        entity.setTL14(model.isTL14());
        entity.setTL14A(model.isTL14A());
        entity.setTL14B(model.isTL14B());
        entity.setTL14P(model.isTL14P());
        entity.setTL14T(model.isTL14T());
        entity.setTL16(model.isTL16());
        entity.setTL15(model.isTL15());
        entity.setTL17(model.isTL17());
        entity.setTL18(model.isTL18());
        entity.setTL19(model.isTL19());
        entity.setTL19A(model.isTL19A());
        entity.setTL21(model.isTL21());
        entity.setTL22(model.isTL22());
        entity.setTL22T(model.isTL22T());
        entity.setTL24(model.isTL24());
        entity.setTL26(model.isTL26());
        entity.setTL26T(model.isTL26T());
        entity.setTL27(model.isTL27());
        entity.setTL27T(model.isTL27T());
        entity.setTL28(model.isTL28());
        entity.setTL28T(model.isTL28T());
        entity.setTL29(model.isTL29());
        entity.setTL29A(model.isTL29A());
        entity.setTL29B(model.isTL29B());
        entity.setTL29C(model.isTL29C());
        entity.setTL30(model.isTL30());
        entity.setTL32(model.isTL32());
        entity.setTL36(model.isTL36());
        entity.setTL36T(model.isTL36T());
        entity.setTL37(model.isTL37());
        entity.setTL38(model.isTL38());
        entity.setTL39(model.isTL39());
        entity.setTL40(model.isTL40());
        entity.setTL41(model.isTL41());
        entity.setTL42(model.isTL42());
        entity.setTL42A(model.isTL42A());
        return entity;
    }

    public List<TestingModel> listToModels(List<TestingEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<TestingEntity> listToEntities(List<TestingModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
