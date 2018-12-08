<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="#(tableMeta.camelName)Mapper">
	<resultMap id="#(tableMeta.camelName)ResultMap" type="#(tableMeta.camelName)">
		#for(cm : tableMeta.columnMetas)
			<result property="#(cm.camelName)" column="#(cm.name)" />
		#end
	</resultMap>

	<sql id="#(tableMeta.name)_property">
		#for(cm : tableMeta.columnMetas)
			#(tableMeta.name).#(cm.name) #if(!for.last),#end
		#end
	</sql>

	<select id="list" parameterType="#(tableMeta.camelName)" resultMap="#(tableMeta.camelName)ResultMap">
		SELECT
			<include refid="#(tableMeta.name)_property"></include>
		FROM
			 #(tableMeta.name)
	</select>
	
	
	<select id="getById" parameterType="int" resultMap="#(tableMeta.camelName)ResultMap">
		SELECT
			<include refid="#(tableMeta.name)_property"></include>
		FROM
			 #(tableMeta.name)
		where
			#(tableMeta.primaryKey)=#{value}	
	</select>
	
	
	<select id="count"  resultType="java.lang.Integer">
		select 
			count(1)
		from
			 #(tableMeta.name)
	</select>
	
	<select id="update" parameterType="#(tableMeta.camelName)" resultMap="#(tableMeta.camelName)ResultMap">
		update  
			#(tableMeta.name) 
		    <trim prefix="(" suffix=")" suffixOverrides=",">
				#for(cm : tableMeta.columnMetas)
					 <if test="#(cm.camelName)!=null">
						#(cm.name)=#{#(cm.camelName)},
					 </if>
			    #end
			</trim>
		where
			#(tableMeta.primaryKey) =#{value}
	</select>
	 
	<update id="delete" parameterType="java.lang.Integer">
		delete 
		from
			 #(tableMeta.name)
		where
			#(tableMeta.primaryKey)=#{value}
	</update>
	
 
    <insert id="save" parameterType="#(tableMeta.camelName)"
            useGeneratedKeys="true" keyProperty="pkId" keyColumn="pk_id">
	insert into
	 #(tableMeta.name)
		  <trim prefix="(" suffix=")" suffixOverrides=",">
		 	#for(cm : tableMeta.columnMetas)
				 <if test="#(cm.camelName)!=null">
					#(cm.name),
				 </if>
		    #end
		  </trim>
		values 
			<trim prefix="(" suffix=")" suffixOverrides=",">
			 	#for(cm : tableMeta.columnMetas)
					 <if test="#(cm.camelName)!=null">
						#{#(cm.camelName)},
					 </if>
			    #end
		  </trim>
	</insert>
	
</mapper>