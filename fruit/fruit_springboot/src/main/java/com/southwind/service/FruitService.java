package com.southwind.service;

import com.southwind.entity.Fruit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.southwind.vo.BarVO;
import com.southwind.vo.PieVO;

import java.util.List;

/**
 *  服务类
 */
public interface FruitService extends IService<Fruit> {
    public BarVO barVOList();
    public List<PieVO> pieVOList();
}
