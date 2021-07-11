package com.southwind.service.impl;

import com.southwind.entity.Fruit;
import com.southwind.mapper.FruitMapper;
import com.southwind.service.FruitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-07-12
 */
@Service
public class FruitServiceImpl extends ServiceImpl<FruitMapper, Fruit> implements FruitService {

}
