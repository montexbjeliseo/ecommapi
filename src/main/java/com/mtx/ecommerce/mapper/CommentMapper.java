package com.mtx.ecommerce.mapper;

import com.mtx.ecommerce.dto.request.RegisterCommentDto;
import com.mtx.ecommerce.dto.response.RegisteredCommentDto;
import com.mtx.ecommerce.model.Comment;
import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    RegisteredCommentDto toDto(Comment comment);

    Comment toComment(RegisterCommentDto dto);

    List<RegisteredCommentDto> toDtoList(Set<Comment> comments);
}
