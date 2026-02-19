/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.List;
import br.com.senior.mydomain.myservice.Maquina.Id;
import br.com.senior.springbatchintegration.importer.CrudService;
import br.com.senior.messaging.customspringdata.CustomOrder;
import java.util.Set;
import br.com.senior.messaging.customspringdata.Join;
import org.springframework.data.domain.Page;

public interface MaquinaCrudService extends CrudService<MaquinaEntity> {
	
	public MaquinaEntity createMaquina(MaquinaEntity toCreate);
	
	@Deprecated
	public MaquinaEntity createMergeMaquina(MaquinaEntity toCreateMerge);
	
	public MaquinaEntity updateMaquina(MaquinaEntity toUpdate);
	
	@Deprecated
	public MaquinaEntity updateMergeMaquina(MaquinaEntity toUpdateMerge);
	
	public void deleteMaquina(Id id);
	
	public MaquinaEntity retrieveMaquina(Id id);
	
	@Deprecated
	public List<MaquinaEntity> listMaquina(int skip, int top);
	
	public Page<MaquinaEntity> listMaquinaPageable(int skip, int top);
	
	public Page<MaquinaEntity> listMaquinaPageable(int skip, int top, String orderBy);
	
	public Page<MaquinaEntity> listMaquinaPageable(int skip, int top, String orderBy, String filter);
	
	public void createBulkMaquina(List<MaquinaEntity> entities);

	public MaquinaBaseRepository getRepository();
	
	public void validateFilterColumns(Set<String> columns, List<Join> joinFields, String lastPath);
	
	public void validateCustomOrders(List<CustomOrder> customOrders);
	
}
