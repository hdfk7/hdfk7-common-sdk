package cn.hdfk7.boot.proto.base.mapstruct;

import cn.hdfk7.boot.proto.base.model.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;

import java.util.List;

public interface BaseMapstruct<D, V> {

    V d2v(D source);

    D v2d(V source);

    List<V> d2v(List<D> source);

    List<D> v2d(List<V> source);

    Page<V> d2v(PageDTO<D> source);

    Page<D> v2d(PageDTO<V> source);

}
