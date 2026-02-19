/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.List;
import br.com.senior.mydomain.myservice.Registro_producao.Id;
import br.com.senior.springbatchintegration.importer.CrudService;
import br.com.senior.messaging.customspringdata.CustomOrder;
import java.util.Set;
import br.com.senior.messaging.customspringdata.Join;
import org.springframework.data.domain.Page;

public interface Registro_producaoCrudService extends CrudService<Registro_producaoEntity> {
	
	public Registro_producaoEntity createRegistro_producao(Registro_producaoEntity toCreate);
	
	@Deprecated
	public Registro_producaoEntity createMergeRegistro_producao(Registro_producaoEntity toCreateMerge);
	
	public Registro_producaoEntity updateRegistro_producao(Registro_producaoEntity toUpdate);
	
	@Deprecated
	public Registro_producaoEntity updateMergeRegistro_producao(Registro_producaoEntity toUpdateMerge);
	
	public void deleteRegistro_producao(Id id);
	
	public Registro_producaoEntity retrieveRegistro_producao(Id id);
	
	@Deprecated
	public List<Registro_producaoEntity> listRegistro_producao(int skip, int top);
	
	public Page<Registro_producaoEntity> listRegistro_producaoPageable(int skip, int top);
	
	public Page<Registro_producaoEntity> listRegistro_producaoPageable(int skip, int top, String orderBy);
	
	public Page<Registro_producaoEntity> listRegistro_producaoPageable(int skip, int top, String orderBy, String filter);
	
	public void createBulkRegistro_producao(List<Registro_producaoEntity> entities);

	public Registro_producaoBaseRepository getRepository();
	
	public void validateFilterColumns(Set<String> columns, List<Join> joinFields, String lastPath);
	
	public void validateCustomOrders(List<CustomOrder> customOrders);
	
}
