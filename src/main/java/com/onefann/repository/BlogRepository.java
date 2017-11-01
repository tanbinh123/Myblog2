package com.onefann.repository;

import com.onefann.domain.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by one_fann on 2017/10/19.
 */
public interface BlogRepository extends JpaRepository<Blog,Long> {

    /**
     * 按博客类别归档
     * @return
     */
    @Query(value = "select blog_type.name,count(*) from blog,blog_type where blog_type = blog_type.id group by blog_type",nativeQuery=true)
    List<Object[]> BlogTypeArchive();

    /**
     * 按年月归档
     * @return
     */
    @Query(value = "select DATE_FORMAT(create_time,\"%Y年%m月\"),count(*) from blog group by DATE_FORMAT(create_time,\"%Y年%m月\") order by create_time desc",nativeQuery = true)
    List<java.lang.Object[]> DateArchive();


    /**
     * 查询博客列表（部分字段）（用于博客首页）
     * @return
     */
    @Query("select new map(b.id as id,b.title as title,b.summary as summary,b.createTime as createTime,b.readSize as readSize,b.commentSize as commentSize,b.blogType as blogType,b.tags as tags) from Blog b")
    Page<Map<String,Object>> blogDataPage(Pageable pageable);

    /**
     * 批量删除博客
     *
     * @param ids
     */
    @Modifying
    @Query("delete from Blog b where b.id in :ids")
    public void deleteByIds(@Param(value = "ids") List<Long> ids);

    /**
     * 根据 年月 查找博客
     * @param date
     * @param pageable
     * @return
     */
    @Query(value = "select id,title,summary,create_time,read_size,comment_size,blog_type from blog where DATE_FORMAT(create_time,\"%Y年%m月\") =  ?1 \n-- #pageable\n",
            countQuery = "select count(*) from blog where DATE_FORMAT(create_time,\"%Y年%m月\") =  ?1",
            nativeQuery = true)
    Page<Object[]> findByCreateTime(String date,Pageable pageable);


}
