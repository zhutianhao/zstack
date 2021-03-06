package org.zstack.network.l3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.zstack.core.db.DatabaseFacade;
import org.zstack.header.network.l3.*;

public class L3BasicNetworkFactory implements L3NetworkFactory {
    private static final L3NetworkType type = new L3NetworkType(L3NetworkConstant.L3_BASIC_NETWORK_TYPE);
    
    @Autowired
    private DatabaseFacade dbf;

    @Override
    public L3NetworkType getType() {
        return type;
    }

    @Override
    @Transactional
    public L3NetworkInventory createL3Network(L3NetworkVO l3vo, APICreateL3NetworkMsg msg) {
        l3vo.setType(type.toString());
        dbf.getEntityManager().persist(l3vo);
        dbf.getEntityManager().flush();
        dbf.getEntityManager().refresh(l3vo);
        return L3NetworkInventory.valueOf(l3vo);
    }

    @Override
    public L3Network getL3Network(L3NetworkVO vo) {
        return new L3BasicNetwork(vo);
    }

    @Override
    public boolean applyNetworkServiceWhenVmStateChange() {
        return true;
    }
}
