package com.hdfk7.proto.base.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "分页请求实体")
public class PageModel<T> extends BaseModel {
    @Min(1)
    @Max(1000)
    @NotNull
    @Schema(description = "页大小")
    private long size = 10;

    @Min(1)
    @NotNull
    @Schema(description = "当前页")
    private long current = 1;

    @NotNull
    @Schema(description = "查询条件")
    public T query;

    public <E> PageDTO<E> of() {
        return new PageDTO<>(current, size);
    }
}
