<#if ejb3>
<#if pojo.hasIdentifierProperty()>
<#if property.equals(clazz.identifierProperty)>
 ${pojo.generateAnnIdGenerator()}
 <#-- Pour ORACLE - Start -->
 <#--
 @${pojo.importType("javax.persistence.GeneratedValue")}(strategy = ${pojo.importType("javax.persistence.GenerationType")}.SEQUENCE, generator = "SEQ_${clazz.table.name}") 
 @${pojo.importType("javax.persistence.SequenceGenerator")}(name = "SEQ_${clazz.table.name}", sequenceName = "SEQ_${clazz.table.name}", allocationSize=1) 
-->
<#-- Pour ORACLE - End -->
<#-- if this is the id property (getter)-->
<#-- explicitly set the column name for this property-->
</#if>
</#if>

<#if c2h.isOneToOne(property)>
${pojo.generateOneToOneAnnotation(property, cfg)}
<#elseif c2h.isManyToOne(property)>
${pojo.generateManyToOneAnnotation(property)}
<#--TODO support optional and targetEntity-->    
${pojo.generateJoinColumnsAnnotation(property, cfg)}
<#elseif c2h.isCollection(property)>
${pojo.generateCollectionAnnotation(property, cfg)}
<#else>
${pojo.generateBasicAnnotation(property)}
${pojo.generateAnnColumnAnnotation(property)}
</#if>
</#if>