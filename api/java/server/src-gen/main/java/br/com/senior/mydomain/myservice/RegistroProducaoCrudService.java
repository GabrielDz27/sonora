/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.List;
import br.com.senior.mydomain.myservice.RegistroProducao.Id;
import br.com.senior.springbatchintegration.importer.CrudService;
import br.com.senior.messaging.customspringdata.CustomOrder;
import java.util.Set;
import br.com.senior.messaging.customspringdata.Join;
import org.springframework.data.domain.Page;

public interface RegistroProducaoCrudService extends CrudService<RegistroProducaoEntity> {
	
	public RegistroProducaoEntity createRegistroProducao(RegistroProducaoEntity toCreate);
	
	@Deprecated
	public RegistroProducaoEntity createMergeRegistroProducao(RegistroProducaoEntity toCreateMerge);
	
	public RegistroProducaoEntity updateRegistroProducao(RegistroProducaoEntity toUpdate);
	
	@Deprecated
	public RegistroProducaoEntity updateMergeRegistroProducao(RegistroProducaoEntity toUpdateMerge);
	
	public void deleteRegistroProducao(Id id);
	
	public RegistroProducaoEntity retrieveRegistroProducao(Id id);
	
	@Deprecated
	public List<RegistroProducaoEntity> listRegistroProducao(int skip, int top);
	
	public Page<RegistroProducaoEntity> listRegistroProducaoPageable(int skip, int top);
	
	public Page<RegistroProducaoEntity> listRegistroProducaoPageable(int skip, int top, String orderBy);
	
	public Page<RegistroProducaoEntity> listRegistroProducaoPageable(int skip, int top, String orderBy, String filter);
	
	public void createBulkRegistroProducao(List<RegistroProducaoEntity> entities);

	public RegistroProducaoBaseRepository getRepository();
	
	public void validateFilterColumns(Set<String> columns, List<Join> joinFields, String lastPath);
	
	public void validateCustomOrders(List<CustomOrder> customOrders);
	
}
