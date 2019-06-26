<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="#(tableMeta.camelName)Mapper">
	<resultMap id="#(tableMeta.camelName)ResultMap" type="#(tableMeta.camelName)">
		#for(cm : tableMeta.columnMetas)
			<result property="#(cm.javaName)" column="#(cm.name)" />
		#end
	</resultMap>

	<sql id="#(tableMeta.camelName)_property">
		#for(cm : tableMeta.columnMetas)
			#(tableMeta.tableName).#(cm.name) #if(!for.last),#end
		#end
	</sql>
 
    <insert id="save" parameterType="#(tableMeta.camelName)"
            useGeneratedKeys="true" keyProperty="pkId" keyColumn="pk_id">
	insert into
	 #(tableMeta.tableName)
		  <trim prefix="(" suffix=")" suffixOverrides=",">
		 	#for(cm : tableMeta.columnMetas)
				 <if test="#(cm.javaName)!=null">
					#(cm.name),
				 </if>
		    #end
		  </trim>
		values 
			<trim prefix="(" suffix=")" suffixOverrides=",">
			 	#for(cm : tableMeta.columnMetas)
					 <if test="#(cm.javaName)!=null">
						#{#(cm.javaName)},
					 </if>
			    #end
		  </trim>
	</insert>
	
	<update id="delete" parameterType="java.lang.Integer">
		delete 
		from
			 #(tableMeta.tableName)
		where
			#(tableMeta.primaryKey)=#{value}
	</update>
 
	<update id="update" parameterType="#(tableMeta.camelName)" resultType="boolean">
		update  
			#(tableMeta.tableName) 
		    <trim prefix="set" suffixOverrides=",">
				#for(cm : tableMeta.columnMetas)
					 <if test="#(cm.javaName)!=null">
						#(cm.name)=#{#(cm.javaName)},
					 </if>
			    #end
			</trim>
		where
			#(tableMeta.primaryKey) =#{#(tableMeta.primaryKeySmall)}
	</update>
	
	<select id="list" parameterType="map" resultMap="#(tableMeta.camelName)ResultMap">
		SELECT
			<include refid="#(tableMeta.camelName)_property"></include>
		FROM
			 #(tableMeta.tableName)
		<if test="page!=null">
			limit #{page.startRow},#{page.pageSize}
		</if>
	</select>
 
	<select id="getById" parameterType="int" resultMap="#(tableMeta.camelName)ResultMap">
		SELECT
			<include refid="#(tableMeta.camelName)_property"></include>
		FROM
			 #(tableMeta.tableName)
		where
			#(tableMeta.primaryKey)=#{value}	
	</select>
	
	
	<select id="count"  resultType="java.lang.Integer">
		select 
			count(1)
		from
			 #(tableMeta.tableName)
	</select>
	
</mapper>