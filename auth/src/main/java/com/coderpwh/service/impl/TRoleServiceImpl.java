package com.coderpwh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderpwh.mapper.TRoleMapper;
import com.coderpwh.model.TRole;
import com.coderpwh.service.TRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class TRoleServiceImpl implements TRoleService {


    @Autowired
     private TRoleMapper tRoleMapper;

    @Override
    public List<String> selectAllByUsername(String username) {
        return tRoleMapper.selectAllByUserName(username);
    }




    @Override
    public boolean saveBatch(Collection<TRole> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<TRole> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<TRole> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(TRole entity) {
        return false;
    }

    @Override
    public TRole getOne(Wrapper<TRole> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<TRole> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<TRole> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<TRole> getBaseMapper() {
        return null;
    }
}
