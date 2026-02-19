/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.concurrent.CompletableFuture;


/**
* 
*/
public interface MyServiceStub {

	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	HelloWorldOutput helloWorld(HelloWorldInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void helloWorld(HelloWorldInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<HelloWorldOutput> helloWorldRequest(HelloWorldInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<HelloWorldOutput> helloWorldRequest(HelloWorldInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	GetMetadataOutput getMetadata(GetMetadataInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * Chamada assíncrona
	 */
	void getMetadata(GetMetadataInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetMetadataOutput> getMetadataRequest(GetMetadataInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetMetadataOutput> getMetadataRequest(GetMetadataInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportPecaOutput importPeca(ImportPecaInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void importPeca(ImportPecaInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportPecaOutput> importPecaRequest(ImportPecaInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportPecaOutput> importPecaRequest(ImportPecaInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportPecaOutput exportPeca(ExportPecaInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void exportPeca(ExportPecaInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportPecaOutput> exportPecaRequest(ExportPecaInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportPecaOutput> exportPecaRequest(ExportPecaInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportFuncionarioOutput importFuncionario(ImportFuncionarioInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void importFuncionario(ImportFuncionarioInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportFuncionarioOutput> importFuncionarioRequest(ImportFuncionarioInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportFuncionarioOutput> importFuncionarioRequest(ImportFuncionarioInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportFuncionarioOutput exportFuncionario(ExportFuncionarioInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void exportFuncionario(ExportFuncionarioInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportFuncionarioOutput> exportFuncionarioRequest(ExportFuncionarioInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportFuncionarioOutput> exportFuncionarioRequest(ExportFuncionarioInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportMaquinaOutput importMaquina(ImportMaquinaInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void importMaquina(ImportMaquinaInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportMaquinaOutput> importMaquinaRequest(ImportMaquinaInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportMaquinaOutput> importMaquinaRequest(ImportMaquinaInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportMaquinaOutput exportMaquina(ExportMaquinaInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void exportMaquina(ExportMaquinaInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportMaquinaOutput> exportMaquinaRequest(ExportMaquinaInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportMaquinaOutput> exportMaquinaRequest(ExportMaquinaInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportRegistro_producaoOutput importRegistro_producao(ImportRegistro_producaoInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void importRegistro_producao(ImportRegistro_producaoInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportRegistro_producaoOutput> importRegistro_producaoRequest(ImportRegistro_producaoInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportRegistro_producaoOutput> importRegistro_producaoRequest(ImportRegistro_producaoInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportRegistro_producaoOutput exportRegistro_producao(ExportRegistro_producaoInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void exportRegistro_producao(ExportRegistro_producaoInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportRegistro_producaoOutput> exportRegistro_producaoRequest(ExportRegistro_producaoInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportRegistro_producaoOutput> exportRegistro_producaoRequest(ExportRegistro_producaoInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	GetDependenciesOutput getDependencies(long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * Chamada assíncrona
	 */
	void getDependencies();
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetDependenciesOutput> getDependenciesRequest();
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetDependenciesOutput> getDependenciesRequest(long timeout);
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Peca entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Peca createPeca(Peca input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Peca entity.
	 * Chamada assíncrona
	 */
	void createPeca(Peca input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca> createPecaRequest(Peca input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca> createPecaRequest(Peca input, long timeout);
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Peca entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkPecaOutput createBulkPeca(CreateBulkPecaInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Peca entity.
	 * Chamada assíncrona
	 */
	void createBulkPeca(CreateBulkPecaInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkPecaOutput> createBulkPecaRequest(CreateBulkPecaInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkPecaOutput> createBulkPecaRequest(CreateBulkPecaInput input, long timeout);
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Peca entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Peca createMergePeca(Peca input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Peca entity.
	 * Chamada assíncrona
	 */
	void createMergePeca(Peca input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca> createMergePecaRequest(Peca input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca> createMergePecaRequest(Peca input, long timeout);
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Peca entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Peca retrievePeca(Peca.GetRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Peca entity.
	 * Chamada assíncrona
	 */
	void retrievePeca(Peca.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca> retrievePecaRequest(Peca.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca> retrievePecaRequest(Peca.GetRequest input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Peca entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Peca.PagedResults listPeca(Peca.PageRequest input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Peca entity.
	 * Chamada assíncrona
	 */
	void listPeca(Peca.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca.PagedResults> listPecaRequest(Peca.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca.PagedResults> listPecaRequest(Peca.PageRequest input, long timeout);
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Peca entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Peca updatePeca(Peca input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Peca entity.
	 * Chamada assíncrona
	 */
	void updatePeca(Peca input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca> updatePecaRequest(Peca input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca> updatePecaRequest(Peca input, long timeout);
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Peca entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Peca updateMergePeca(Peca input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Peca entity.
	 * Chamada assíncrona
	 */
	void updateMergePeca(Peca input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca> updateMergePecaRequest(Peca input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Peca entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Peca> updateMergePecaRequest(Peca input, long timeout);
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Peca entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deletePeca(Peca.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Peca entity.
	 * Chamada assíncrona
	 */
	void deletePeca(Peca.Id input);
	
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Funcionario entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Funcionario createFuncionario(Funcionario input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Funcionario entity.
	 * Chamada assíncrona
	 */
	void createFuncionario(Funcionario input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario> createFuncionarioRequest(Funcionario input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario> createFuncionarioRequest(Funcionario input, long timeout);
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Funcionario entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkFuncionarioOutput createBulkFuncionario(CreateBulkFuncionarioInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Funcionario entity.
	 * Chamada assíncrona
	 */
	void createBulkFuncionario(CreateBulkFuncionarioInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkFuncionarioOutput> createBulkFuncionarioRequest(CreateBulkFuncionarioInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkFuncionarioOutput> createBulkFuncionarioRequest(CreateBulkFuncionarioInput input, long timeout);
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Funcionario entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Funcionario createMergeFuncionario(Funcionario input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Funcionario entity.
	 * Chamada assíncrona
	 */
	void createMergeFuncionario(Funcionario input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario> createMergeFuncionarioRequest(Funcionario input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario> createMergeFuncionarioRequest(Funcionario input, long timeout);
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Funcionario entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Funcionario retrieveFuncionario(Funcionario.GetRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Funcionario entity.
	 * Chamada assíncrona
	 */
	void retrieveFuncionario(Funcionario.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario> retrieveFuncionarioRequest(Funcionario.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario> retrieveFuncionarioRequest(Funcionario.GetRequest input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Funcionario entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Funcionario.PagedResults listFuncionario(Funcionario.PageRequest input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Funcionario entity.
	 * Chamada assíncrona
	 */
	void listFuncionario(Funcionario.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario.PagedResults> listFuncionarioRequest(Funcionario.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario.PagedResults> listFuncionarioRequest(Funcionario.PageRequest input, long timeout);
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Funcionario entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Funcionario updateFuncionario(Funcionario input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Funcionario entity.
	 * Chamada assíncrona
	 */
	void updateFuncionario(Funcionario input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario> updateFuncionarioRequest(Funcionario input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario> updateFuncionarioRequest(Funcionario input, long timeout);
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Funcionario entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Funcionario updateMergeFuncionario(Funcionario input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Funcionario entity.
	 * Chamada assíncrona
	 */
	void updateMergeFuncionario(Funcionario input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario> updateMergeFuncionarioRequest(Funcionario input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Funcionario entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Funcionario> updateMergeFuncionarioRequest(Funcionario input, long timeout);
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Funcionario entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deleteFuncionario(Funcionario.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Funcionario entity.
	 * Chamada assíncrona
	 */
	void deleteFuncionario(Funcionario.Id input);
	
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Maquina entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Maquina createMaquina(Maquina input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Maquina entity.
	 * Chamada assíncrona
	 */
	void createMaquina(Maquina input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina> createMaquinaRequest(Maquina input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina> createMaquinaRequest(Maquina input, long timeout);
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Maquina entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkMaquinaOutput createBulkMaquina(CreateBulkMaquinaInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Maquina entity.
	 * Chamada assíncrona
	 */
	void createBulkMaquina(CreateBulkMaquinaInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkMaquinaOutput> createBulkMaquinaRequest(CreateBulkMaquinaInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkMaquinaOutput> createBulkMaquinaRequest(CreateBulkMaquinaInput input, long timeout);
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Maquina entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Maquina createMergeMaquina(Maquina input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Maquina entity.
	 * Chamada assíncrona
	 */
	void createMergeMaquina(Maquina input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina> createMergeMaquinaRequest(Maquina input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina> createMergeMaquinaRequest(Maquina input, long timeout);
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Maquina entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Maquina retrieveMaquina(Maquina.GetRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Maquina entity.
	 * Chamada assíncrona
	 */
	void retrieveMaquina(Maquina.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina> retrieveMaquinaRequest(Maquina.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina> retrieveMaquinaRequest(Maquina.GetRequest input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Maquina entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Maquina.PagedResults listMaquina(Maquina.PageRequest input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Maquina entity.
	 * Chamada assíncrona
	 */
	void listMaquina(Maquina.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina.PagedResults> listMaquinaRequest(Maquina.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina.PagedResults> listMaquinaRequest(Maquina.PageRequest input, long timeout);
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Maquina entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Maquina updateMaquina(Maquina input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Maquina entity.
	 * Chamada assíncrona
	 */
	void updateMaquina(Maquina input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina> updateMaquinaRequest(Maquina input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina> updateMaquinaRequest(Maquina input, long timeout);
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Maquina entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Maquina updateMergeMaquina(Maquina input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Maquina entity.
	 * Chamada assíncrona
	 */
	void updateMergeMaquina(Maquina input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina> updateMergeMaquinaRequest(Maquina input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Maquina entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Maquina> updateMergeMaquinaRequest(Maquina input, long timeout);
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Maquina entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deleteMaquina(Maquina.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Maquina entity.
	 * Chamada assíncrona
	 */
	void deleteMaquina(Maquina.Id input);
	
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Registro_producao entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Registro_producao createRegistro_producao(Registro_producao input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Registro_producao entity.
	 * Chamada assíncrona
	 */
	void createRegistro_producao(Registro_producao input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao> createRegistro_producaoRequest(Registro_producao input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao> createRegistro_producaoRequest(Registro_producao input, long timeout);
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Registro_producao entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkRegistro_producaoOutput createBulkRegistro_producao(CreateBulkRegistro_producaoInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Registro_producao entity.
	 * Chamada assíncrona
	 */
	void createBulkRegistro_producao(CreateBulkRegistro_producaoInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkRegistro_producaoOutput> createBulkRegistro_producaoRequest(CreateBulkRegistro_producaoInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkRegistro_producaoOutput> createBulkRegistro_producaoRequest(CreateBulkRegistro_producaoInput input, long timeout);
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Registro_producao entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Registro_producao createMergeRegistro_producao(Registro_producao input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Registro_producao entity.
	 * Chamada assíncrona
	 */
	void createMergeRegistro_producao(Registro_producao input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao> createMergeRegistro_producaoRequest(Registro_producao input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao> createMergeRegistro_producaoRequest(Registro_producao input, long timeout);
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Registro_producao entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Registro_producao retrieveRegistro_producao(Registro_producao.GetRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Registro_producao entity.
	 * Chamada assíncrona
	 */
	void retrieveRegistro_producao(Registro_producao.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao> retrieveRegistro_producaoRequest(Registro_producao.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao> retrieveRegistro_producaoRequest(Registro_producao.GetRequest input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Registro_producao entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Registro_producao.PagedResults listRegistro_producao(Registro_producao.PageRequest input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Registro_producao entity.
	 * Chamada assíncrona
	 */
	void listRegistro_producao(Registro_producao.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao.PagedResults> listRegistro_producaoRequest(Registro_producao.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao.PagedResults> listRegistro_producaoRequest(Registro_producao.PageRequest input, long timeout);
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Registro_producao entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Registro_producao updateRegistro_producao(Registro_producao input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Registro_producao entity.
	 * Chamada assíncrona
	 */
	void updateRegistro_producao(Registro_producao input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao> updateRegistro_producaoRequest(Registro_producao input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao> updateRegistro_producaoRequest(Registro_producao input, long timeout);
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Registro_producao entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Registro_producao updateMergeRegistro_producao(Registro_producao input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Registro_producao entity.
	 * Chamada assíncrona
	 */
	void updateMergeRegistro_producao(Registro_producao input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao> updateMergeRegistro_producaoRequest(Registro_producao input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Registro_producao entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Registro_producao> updateMergeRegistro_producaoRequest(Registro_producao input, long timeout);
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Registro_producao entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deleteRegistro_producao(Registro_producao.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Registro_producao entity.
	 * Chamada assíncrona
	 */
	void deleteRegistro_producao(Registro_producao.Id input);
	
	


	/**
	 * Chamada assíncrona para o método publishServiceStarted 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishServiceStarted( ServiceStartedPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishNotifyUserEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishNotifyUserEvent( NotifyUserEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishImportPecaEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishImportPecaEvent( ImportPecaEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishExportPecaEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishExportPecaEvent( ExportPecaEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishImportFuncionarioEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishImportFuncionarioEvent( ImportFuncionarioEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishExportFuncionarioEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishExportFuncionarioEvent( ExportFuncionarioEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishImportMaquinaEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishImportMaquinaEvent( ImportMaquinaEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishExportMaquinaEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishExportMaquinaEvent( ExportMaquinaEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishImportRegistro_producaoEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishImportRegistro_producaoEvent( ImportRegistro_producaoEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishExportRegistro_producaoEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishExportRegistro_producaoEvent( ExportRegistro_producaoEventPayload input );
			
	

}
