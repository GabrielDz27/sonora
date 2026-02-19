/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.List;
import br.com.senior.mydomain.myservice.Peca.Id;
import br.com.senior.springbatchintegration.importer.CrudService;
import br.com.senior.messaging.customspringdata.CustomOrder;
import java.util.Set;
import br.com.senior.messaging.customspringdata.Join;
import org.springframework.data.domain.Page;

public interface PecaCrudService extends CrudService<PecaEntity> {
	
	public PecaEntity createPeca(PecaEntity toCreate);
	
	@Deprecated
	public PecaEntity createMergePeca(PecaEntity toCreateMerge);
	
	public PecaEntity updatePeca(PecaEntity toUpdate);
	
	@Deprecated
	public PecaEntity updateMergePeca(PecaEntity toUpdateMerge);
	
	public void deletePeca(Id id);
	
	public PecaEntity retrievePeca(Id id);
	
	@Deprecated
	public List<PecaEntity> listPeca(int skip, int top);
	
	public Page<PecaEntity> listPecaPageable(int skip, int top);
	
	public Page<PecaEntity> listPecaPageable(int skip, int top, String orderBy);
	
	public Page<PecaEntity> listPecaPageable(int skip, int top, String orderBy, String filter);
	
	public void createBulkPeca(List<PecaEntity> entities);

	public PecaBaseRepository getRepository();
	
	public void validateFilterColumns(Set<String> columns, List<Join> joinFields, String lastPath);
	
	public void validateCustomOrders(List<CustomOrder> customOrders);
	
}
