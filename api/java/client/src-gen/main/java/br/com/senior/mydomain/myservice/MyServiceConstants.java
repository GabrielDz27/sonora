/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

public interface MyServiceConstants {
    String DOMAIN = "my_domain";
    String SERVICE = "my_service";
    
    interface Commands {
    	/**
    	 * Endpoint para teste
    	 * @see HelloWorldInput the request payload
    	 */
    	String HELLO_WORLD = "helloWorld";
    	/**
    	 * The success response primitive for helloWorld.
    	 *
    	 * @see #HELLO_WORLD the request primitive
    	 * @see HelloWorldOutput the response payload
    	 */
    	String HELLO_WORLD_RESPONSE = "helloWorldResponse";
    	/**
    	 * An error response primitive for helloWorld.
    	 *
    	 * @see #HELLO_WORLD the request primitive
    	 */
    	String HELLO_WORLD_ERROR = "helloWorldError";
    	/**
    	 * Quando for feito alguma parte do processo, precisa informar o status
    	 * @see MudarStatusPecaInput the request payload
    	 */
    	String MUDAR_STATUS_PECA = "mudarStatusPeca";
    	/**
    	 * The success response primitive for mudarStatusPeca.
    	 *
    	 * @see #MUDAR_STATUS_PECA the request primitive
    	 * @see MudarStatusPecaOutput the response payload
    	 */
    	String MUDAR_STATUS_PECA_RESPONSE = "mudarStatusPecaResponse";
    	/**
    	 * An error response primitive for mudarStatusPeca.
    	 *
    	 * @see #MUDAR_STATUS_PECA the request primitive
    	 */
    	String MUDAR_STATUS_PECA_ERROR = "mudarStatusPecaError";
    	/**
    	 * Diretamente ja trazendo as maquinas ativas
    	 */
    	String GET_MAQUINA_ATIVA = "getMaquinaAtiva";
    	/**
    	 * The success response primitive for getMaquinaAtiva.
    	 *
    	 * @see #GET_MAQUINA_ATIVA the request primitive
    	 * @see GetMaquinaAtivaOutput the response payload
    	 */
    	String GET_MAQUINA_ATIVA_RESPONSE = "getMaquinaAtivaResponse";
    	/**
    	 * An error response primitive for getMaquinaAtiva.
    	 *
    	 * @see #GET_MAQUINA_ATIVA the request primitive
    	 */
    	String GET_MAQUINA_ATIVA_ERROR = "getMaquinaAtivaError";
    	/**
    	 * Trazendo todas pecas conforme o filtro
    	 */
    	String GET_PECA_PENDENTE = "getPecaPendente";
    	/**
    	 * The success response primitive for getPecaPendente.
    	 *
    	 * @see #GET_PECA_PENDENTE the request primitive
    	 * @see GetPecaPendenteOutput the response payload
    	 */
    	String GET_PECA_PENDENTE_RESPONSE = "getPecaPendenteResponse";
    	/**
    	 * An error response primitive for getPecaPendente.
    	 *
    	 * @see #GET_PECA_PENDENTE the request primitive
    	 */
    	String GET_PECA_PENDENTE_ERROR = "getPecaPendenteError";
    	/**
    	 * @see RelatorioInput the request payload
    	 */
    	String RELATORIO = "relatorio";
    	/**
    	 * The success response primitive for relatorio.
    	 *
    	 * @see #RELATORIO the request primitive
    	 * @see RelatorioOutput the response payload
    	 */
    	String RELATORIO_RESPONSE = "relatorioResponse";
    	/**
    	 * An error response primitive for relatorio.
    	 *
    	 * @see #RELATORIO the request primitive
    	 */
    	String RELATORIO_ERROR = "relatorioError";
    	/**
    	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
    	 * @see GetMetadataInput the request payload
    	 */
    	String GET_METADATA = "getMetadata";
    	/**
    	 * The success response primitive for getMetadata.
    	 *
    	 * @see #GET_METADATA the request primitive
    	 * @see GetMetadataOutput the response payload
    	 */
    	String GET_METADATA_RESPONSE = "getMetadataResponse";
    	/**
    	 * An error response primitive for getMetadata.
    	 *
    	 * @see #GET_METADATA the request primitive
    	 */
    	String GET_METADATA_ERROR = "getMetadataError";
    	String ODATA = "odata";
    	/**
    	 * The success response primitive for odata.
    	 *
    	 * @see #ODATA the request primitive
    	 */
    	String ODATA_RESPONSE = "odataResponse";
    	/**
    	 * An error response primitive for odata.
    	 *
    	 * @see #ODATA the request primitive
    	 */
    	String ODATA_ERROR = "odataError";
    	/**
    	 * @see ImportPecaInput the request payload
    	 */
    	String IMPORT_PECA = "importPeca";
    	/**
    	 * The success response primitive for importPeca.
    	 *
    	 * @see #IMPORT_PECA the request primitive
    	 * @see ImportPecaOutput the response payload
    	 */
    	String IMPORT_PECA_RESPONSE = "importPecaResponse";
    	/**
    	 * An error response primitive for importPeca.
    	 *
    	 * @see #IMPORT_PECA the request primitive
    	 */
    	String IMPORT_PECA_ERROR = "importPecaError";
    	/**
    	 * @see ExportPecaInput the request payload
    	 */
    	String EXPORT_PECA = "exportPeca";
    	/**
    	 * The success response primitive for exportPeca.
    	 *
    	 * @see #EXPORT_PECA the request primitive
    	 * @see ExportPecaOutput the response payload
    	 */
    	String EXPORT_PECA_RESPONSE = "exportPecaResponse";
    	/**
    	 * An error response primitive for exportPeca.
    	 *
    	 * @see #EXPORT_PECA the request primitive
    	 */
    	String EXPORT_PECA_ERROR = "exportPecaError";
    	/**
    	 * @see ImportFuncionarioInput the request payload
    	 */
    	String IMPORT_FUNCIONARIO = "importFuncionario";
    	/**
    	 * The success response primitive for importFuncionario.
    	 *
    	 * @see #IMPORT_FUNCIONARIO the request primitive
    	 * @see ImportFuncionarioOutput the response payload
    	 */
    	String IMPORT_FUNCIONARIO_RESPONSE = "importFuncionarioResponse";
    	/**
    	 * An error response primitive for importFuncionario.
    	 *
    	 * @see #IMPORT_FUNCIONARIO the request primitive
    	 */
    	String IMPORT_FUNCIONARIO_ERROR = "importFuncionarioError";
    	/**
    	 * @see ExportFuncionarioInput the request payload
    	 */
    	String EXPORT_FUNCIONARIO = "exportFuncionario";
    	/**
    	 * The success response primitive for exportFuncionario.
    	 *
    	 * @see #EXPORT_FUNCIONARIO the request primitive
    	 * @see ExportFuncionarioOutput the response payload
    	 */
    	String EXPORT_FUNCIONARIO_RESPONSE = "exportFuncionarioResponse";
    	/**
    	 * An error response primitive for exportFuncionario.
    	 *
    	 * @see #EXPORT_FUNCIONARIO the request primitive
    	 */
    	String EXPORT_FUNCIONARIO_ERROR = "exportFuncionarioError";
    	/**
    	 * @see ImportMaquinaInput the request payload
    	 */
    	String IMPORT_MAQUINA = "importMaquina";
    	/**
    	 * The success response primitive for importMaquina.
    	 *
    	 * @see #IMPORT_MAQUINA the request primitive
    	 * @see ImportMaquinaOutput the response payload
    	 */
    	String IMPORT_MAQUINA_RESPONSE = "importMaquinaResponse";
    	/**
    	 * An error response primitive for importMaquina.
    	 *
    	 * @see #IMPORT_MAQUINA the request primitive
    	 */
    	String IMPORT_MAQUINA_ERROR = "importMaquinaError";
    	/**
    	 * @see ExportMaquinaInput the request payload
    	 */
    	String EXPORT_MAQUINA = "exportMaquina";
    	/**
    	 * The success response primitive for exportMaquina.
    	 *
    	 * @see #EXPORT_MAQUINA the request primitive
    	 * @see ExportMaquinaOutput the response payload
    	 */
    	String EXPORT_MAQUINA_RESPONSE = "exportMaquinaResponse";
    	/**
    	 * An error response primitive for exportMaquina.
    	 *
    	 * @see #EXPORT_MAQUINA the request primitive
    	 */
    	String EXPORT_MAQUINA_ERROR = "exportMaquinaError";
    	/**
    	 * @see ImportRegistroProducaoInput the request payload
    	 */
    	String IMPORT_REGISTRO_PRODUCAO = "importRegistroProducao";
    	/**
    	 * The success response primitive for importRegistroProducao.
    	 *
    	 * @see #IMPORT_REGISTRO_PRODUCAO the request primitive
    	 * @see ImportRegistroProducaoOutput the response payload
    	 */
    	String IMPORT_REGISTRO_PRODUCAO_RESPONSE = "importRegistroProducaoResponse";
    	/**
    	 * An error response primitive for importRegistroProducao.
    	 *
    	 * @see #IMPORT_REGISTRO_PRODUCAO the request primitive
    	 */
    	String IMPORT_REGISTRO_PRODUCAO_ERROR = "importRegistroProducaoError";
    	/**
    	 * @see ExportRegistroProducaoInput the request payload
    	 */
    	String EXPORT_REGISTRO_PRODUCAO = "exportRegistroProducao";
    	/**
    	 * The success response primitive for exportRegistroProducao.
    	 *
    	 * @see #EXPORT_REGISTRO_PRODUCAO the request primitive
    	 * @see ExportRegistroProducaoOutput the response payload
    	 */
    	String EXPORT_REGISTRO_PRODUCAO_RESPONSE = "exportRegistroProducaoResponse";
    	/**
    	 * An error response primitive for exportRegistroProducao.
    	 *
    	 * @see #EXPORT_REGISTRO_PRODUCAO the request primitive
    	 */
    	String EXPORT_REGISTRO_PRODUCAO_ERROR = "exportRegistroProducaoError";
    	/**
    	 * Returns a list with all dependencies from this service, along with their respective versions
    	 */
    	String GET_DEPENDENCIES = "getDependencies";
    	/**
    	 * The success response primitive for getDependencies.
    	 *
    	 * @see #GET_DEPENDENCIES the request primitive
    	 * @see GetDependenciesOutput the response payload
    	 */
    	String GET_DEPENDENCIES_RESPONSE = "getDependenciesResponse";
    	/**
    	 * An error response primitive for getDependencies.
    	 *
    	 * @see #GET_DEPENDENCIES the request primitive
    	 */
    	String GET_DEPENDENCIES_ERROR = "getDependenciesError";
    	/**
    	 * The 'create' request primitive for the Peca entity.
    	 * @see Peca the request payload
    	 */
    	String CREATE_PECA = "createPeca";
    	/**
    	 * The success response primitive for createPeca.
    	 *
    	 * @see #CREATE_PECA the request primitive
    	 */
    	String CREATE_PECA_RESPONSE = "createPecaResponse";
    	/**
    	 * An error response primitive for createPeca.
    	 *
    	 * @see #CREATE_PECA the request primitive
    	 */
    	String CREATE_PECA_ERROR = "createPecaError";
    	/**
    	 * The 'createBulk' request primitive for the Peca entity.
    	 * @see CreateBulkPecaInput the request payload
    	 */
    	String CREATE_BULK_PECA = "createBulkPeca";
    	/**
    	 * The success response primitive for createBulkPeca.
    	 *
    	 * @see #CREATE_BULK_PECA the request primitive
    	 * @see CreateBulkPecaOutput the response payload
    	 */
    	String CREATE_BULK_PECA_RESPONSE = "createBulkPecaResponse";
    	/**
    	 * An error response primitive for createBulkPeca.
    	 *
    	 * @see #CREATE_BULK_PECA the request primitive
    	 */
    	String CREATE_BULK_PECA_ERROR = "createBulkPecaError";
    	/**
    	 * The 'createMerge' request primitive for the Peca entity.
    	 * @see Peca the request payload
    	 */
    	String CREATE_MERGE_PECA = "createMergePeca";
    	/**
    	 * The success response primitive for createMergePeca.
    	 *
    	 * @see #CREATE_MERGE_PECA the request primitive
    	 */
    	String CREATE_MERGE_PECA_RESPONSE = "createMergePecaResponse";
    	/**
    	 * An error response primitive for createMergePeca.
    	 *
    	 * @see #CREATE_MERGE_PECA the request primitive
    	 */
    	String CREATE_MERGE_PECA_ERROR = "createMergePecaError";
    	/**
    	 * The 'retrieve' request primitive for the Peca entity.
    	 * @see Peca.GetRequest the request payload
    	 */
    	String RETRIEVE_PECA = "retrievePeca";
    	/**
    	 * The success response primitive for retrievePeca.
    	 *
    	 * @see #RETRIEVE_PECA the request primitive
    	 */
    	String RETRIEVE_PECA_RESPONSE = "retrievePecaResponse";
    	/**
    	 * An error response primitive for retrievePeca.
    	 *
    	 * @see #RETRIEVE_PECA the request primitive
    	 */
    	String RETRIEVE_PECA_ERROR = "retrievePecaError";
    	/**
    	 * The 'list' request primitive for the Peca entity.
    	 * @see peca.pageRequest the request payload
    	 */
    	String LIST_PECA = "listPeca";
    	/**
    	 * The success response primitive for listPeca.
    	 *
    	 * @see #LIST_PECA the request primitive
    	 * @see Peca.PagedResults the response payload
    	 */
    	String LIST_PECA_RESPONSE = "listPecaResponse";
    	/**
    	 * An error response primitive for listPeca.
    	 *
    	 * @see #LIST_PECA the request primitive
    	 */
    	String LIST_PECA_ERROR = "listPecaError";
    	/**
    	 * The 'update' request primitive for the Peca entity.
    	 * @see Peca the request payload
    	 */
    	String UPDATE_PECA = "updatePeca";
    	/**
    	 * The success response primitive for updatePeca.
    	 *
    	 * @see #UPDATE_PECA the request primitive
    	 */
    	String UPDATE_PECA_RESPONSE = "updatePecaResponse";
    	/**
    	 * An error response primitive for updatePeca.
    	 *
    	 * @see #UPDATE_PECA the request primitive
    	 */
    	String UPDATE_PECA_ERROR = "updatePecaError";
    	/**
    	 * The 'updateMerge' request primitive for the Peca entity.
    	 * @see Peca the request payload
    	 */
    	String UPDATE_MERGE_PECA = "updateMergePeca";
    	/**
    	 * The success response primitive for updateMergePeca.
    	 *
    	 * @see #UPDATE_MERGE_PECA the request primitive
    	 */
    	String UPDATE_MERGE_PECA_RESPONSE = "updateMergePecaResponse";
    	/**
    	 * An error response primitive for updateMergePeca.
    	 *
    	 * @see #UPDATE_MERGE_PECA the request primitive
    	 */
    	String UPDATE_MERGE_PECA_ERROR = "updateMergePecaError";
    	/**
    	 * The 'delete' request primitive for the Peca entity.
    	 * @see Peca.Id the request payload
    	 */
    	String DELETE_PECA = "deletePeca";
    	/**
    	 * The success response primitive for deletePeca.
    	 *
    	 * @see #DELETE_PECA the request primitive
    	 */
    	String DELETE_PECA_RESPONSE = "deletePecaResponse";
    	/**
    	 * An error response primitive for deletePeca.
    	 *
    	 * @see #DELETE_PECA the request primitive
    	 */
    	String DELETE_PECA_ERROR = "deletePecaError";
    	/**
    	 * The 'create' request primitive for the Funcionario entity.
    	 * @see Funcionario the request payload
    	 */
    	String CREATE_FUNCIONARIO = "createFuncionario";
    	/**
    	 * The success response primitive for createFuncionario.
    	 *
    	 * @see #CREATE_FUNCIONARIO the request primitive
    	 */
    	String CREATE_FUNCIONARIO_RESPONSE = "createFuncionarioResponse";
    	/**
    	 * An error response primitive for createFuncionario.
    	 *
    	 * @see #CREATE_FUNCIONARIO the request primitive
    	 */
    	String CREATE_FUNCIONARIO_ERROR = "createFuncionarioError";
    	/**
    	 * The 'createBulk' request primitive for the Funcionario entity.
    	 * @see CreateBulkFuncionarioInput the request payload
    	 */
    	String CREATE_BULK_FUNCIONARIO = "createBulkFuncionario";
    	/**
    	 * The success response primitive for createBulkFuncionario.
    	 *
    	 * @see #CREATE_BULK_FUNCIONARIO the request primitive
    	 * @see CreateBulkFuncionarioOutput the response payload
    	 */
    	String CREATE_BULK_FUNCIONARIO_RESPONSE = "createBulkFuncionarioResponse";
    	/**
    	 * An error response primitive for createBulkFuncionario.
    	 *
    	 * @see #CREATE_BULK_FUNCIONARIO the request primitive
    	 */
    	String CREATE_BULK_FUNCIONARIO_ERROR = "createBulkFuncionarioError";
    	/**
    	 * The 'createMerge' request primitive for the Funcionario entity.
    	 * @see Funcionario the request payload
    	 */
    	String CREATE_MERGE_FUNCIONARIO = "createMergeFuncionario";
    	/**
    	 * The success response primitive for createMergeFuncionario.
    	 *
    	 * @see #CREATE_MERGE_FUNCIONARIO the request primitive
    	 */
    	String CREATE_MERGE_FUNCIONARIO_RESPONSE = "createMergeFuncionarioResponse";
    	/**
    	 * An error response primitive for createMergeFuncionario.
    	 *
    	 * @see #CREATE_MERGE_FUNCIONARIO the request primitive
    	 */
    	String CREATE_MERGE_FUNCIONARIO_ERROR = "createMergeFuncionarioError";
    	/**
    	 * The 'retrieve' request primitive for the Funcionario entity.
    	 * @see Funcionario.GetRequest the request payload
    	 */
    	String RETRIEVE_FUNCIONARIO = "retrieveFuncionario";
    	/**
    	 * The success response primitive for retrieveFuncionario.
    	 *
    	 * @see #RETRIEVE_FUNCIONARIO the request primitive
    	 */
    	String RETRIEVE_FUNCIONARIO_RESPONSE = "retrieveFuncionarioResponse";
    	/**
    	 * An error response primitive for retrieveFuncionario.
    	 *
    	 * @see #RETRIEVE_FUNCIONARIO the request primitive
    	 */
    	String RETRIEVE_FUNCIONARIO_ERROR = "retrieveFuncionarioError";
    	/**
    	 * The 'list' request primitive for the Funcionario entity.
    	 * @see funcionario.pageRequest the request payload
    	 */
    	String LIST_FUNCIONARIO = "listFuncionario";
    	/**
    	 * The success response primitive for listFuncionario.
    	 *
    	 * @see #LIST_FUNCIONARIO the request primitive
    	 * @see Funcionario.PagedResults the response payload
    	 */
    	String LIST_FUNCIONARIO_RESPONSE = "listFuncionarioResponse";
    	/**
    	 * An error response primitive for listFuncionario.
    	 *
    	 * @see #LIST_FUNCIONARIO the request primitive
    	 */
    	String LIST_FUNCIONARIO_ERROR = "listFuncionarioError";
    	/**
    	 * The 'update' request primitive for the Funcionario entity.
    	 * @see Funcionario the request payload
    	 */
    	String UPDATE_FUNCIONARIO = "updateFuncionario";
    	/**
    	 * The success response primitive for updateFuncionario.
    	 *
    	 * @see #UPDATE_FUNCIONARIO the request primitive
    	 */
    	String UPDATE_FUNCIONARIO_RESPONSE = "updateFuncionarioResponse";
    	/**
    	 * An error response primitive for updateFuncionario.
    	 *
    	 * @see #UPDATE_FUNCIONARIO the request primitive
    	 */
    	String UPDATE_FUNCIONARIO_ERROR = "updateFuncionarioError";
    	/**
    	 * The 'updateMerge' request primitive for the Funcionario entity.
    	 * @see Funcionario the request payload
    	 */
    	String UPDATE_MERGE_FUNCIONARIO = "updateMergeFuncionario";
    	/**
    	 * The success response primitive for updateMergeFuncionario.
    	 *
    	 * @see #UPDATE_MERGE_FUNCIONARIO the request primitive
    	 */
    	String UPDATE_MERGE_FUNCIONARIO_RESPONSE = "updateMergeFuncionarioResponse";
    	/**
    	 * An error response primitive for updateMergeFuncionario.
    	 *
    	 * @see #UPDATE_MERGE_FUNCIONARIO the request primitive
    	 */
    	String UPDATE_MERGE_FUNCIONARIO_ERROR = "updateMergeFuncionarioError";
    	/**
    	 * The 'delete' request primitive for the Funcionario entity.
    	 * @see Funcionario.Id the request payload
    	 */
    	String DELETE_FUNCIONARIO = "deleteFuncionario";
    	/**
    	 * The success response primitive for deleteFuncionario.
    	 *
    	 * @see #DELETE_FUNCIONARIO the request primitive
    	 */
    	String DELETE_FUNCIONARIO_RESPONSE = "deleteFuncionarioResponse";
    	/**
    	 * An error response primitive for deleteFuncionario.
    	 *
    	 * @see #DELETE_FUNCIONARIO the request primitive
    	 */
    	String DELETE_FUNCIONARIO_ERROR = "deleteFuncionarioError";
    	/**
    	 * The 'create' request primitive for the Maquina entity.
    	 * @see Maquina the request payload
    	 */
    	String CREATE_MAQUINA = "createMaquina";
    	/**
    	 * The success response primitive for createMaquina.
    	 *
    	 * @see #CREATE_MAQUINA the request primitive
    	 */
    	String CREATE_MAQUINA_RESPONSE = "createMaquinaResponse";
    	/**
    	 * An error response primitive for createMaquina.
    	 *
    	 * @see #CREATE_MAQUINA the request primitive
    	 */
    	String CREATE_MAQUINA_ERROR = "createMaquinaError";
    	/**
    	 * The 'createBulk' request primitive for the Maquina entity.
    	 * @see CreateBulkMaquinaInput the request payload
    	 */
    	String CREATE_BULK_MAQUINA = "createBulkMaquina";
    	/**
    	 * The success response primitive for createBulkMaquina.
    	 *
    	 * @see #CREATE_BULK_MAQUINA the request primitive
    	 * @see CreateBulkMaquinaOutput the response payload
    	 */
    	String CREATE_BULK_MAQUINA_RESPONSE = "createBulkMaquinaResponse";
    	/**
    	 * An error response primitive for createBulkMaquina.
    	 *
    	 * @see #CREATE_BULK_MAQUINA the request primitive
    	 */
    	String CREATE_BULK_MAQUINA_ERROR = "createBulkMaquinaError";
    	/**
    	 * The 'createMerge' request primitive for the Maquina entity.
    	 * @see Maquina the request payload
    	 */
    	String CREATE_MERGE_MAQUINA = "createMergeMaquina";
    	/**
    	 * The success response primitive for createMergeMaquina.
    	 *
    	 * @see #CREATE_MERGE_MAQUINA the request primitive
    	 */
    	String CREATE_MERGE_MAQUINA_RESPONSE = "createMergeMaquinaResponse";
    	/**
    	 * An error response primitive for createMergeMaquina.
    	 *
    	 * @see #CREATE_MERGE_MAQUINA the request primitive
    	 */
    	String CREATE_MERGE_MAQUINA_ERROR = "createMergeMaquinaError";
    	/**
    	 * The 'retrieve' request primitive for the Maquina entity.
    	 * @see Maquina.GetRequest the request payload
    	 */
    	String RETRIEVE_MAQUINA = "retrieveMaquina";
    	/**
    	 * The success response primitive for retrieveMaquina.
    	 *
    	 * @see #RETRIEVE_MAQUINA the request primitive
    	 */
    	String RETRIEVE_MAQUINA_RESPONSE = "retrieveMaquinaResponse";
    	/**
    	 * An error response primitive for retrieveMaquina.
    	 *
    	 * @see #RETRIEVE_MAQUINA the request primitive
    	 */
    	String RETRIEVE_MAQUINA_ERROR = "retrieveMaquinaError";
    	/**
    	 * The 'list' request primitive for the Maquina entity.
    	 * @see maquina.pageRequest the request payload
    	 */
    	String LIST_MAQUINA = "listMaquina";
    	/**
    	 * The success response primitive for listMaquina.
    	 *
    	 * @see #LIST_MAQUINA the request primitive
    	 * @see Maquina.PagedResults the response payload
    	 */
    	String LIST_MAQUINA_RESPONSE = "listMaquinaResponse";
    	/**
    	 * An error response primitive for listMaquina.
    	 *
    	 * @see #LIST_MAQUINA the request primitive
    	 */
    	String LIST_MAQUINA_ERROR = "listMaquinaError";
    	/**
    	 * The 'update' request primitive for the Maquina entity.
    	 * @see Maquina the request payload
    	 */
    	String UPDATE_MAQUINA = "updateMaquina";
    	/**
    	 * The success response primitive for updateMaquina.
    	 *
    	 * @see #UPDATE_MAQUINA the request primitive
    	 */
    	String UPDATE_MAQUINA_RESPONSE = "updateMaquinaResponse";
    	/**
    	 * An error response primitive for updateMaquina.
    	 *
    	 * @see #UPDATE_MAQUINA the request primitive
    	 */
    	String UPDATE_MAQUINA_ERROR = "updateMaquinaError";
    	/**
    	 * The 'updateMerge' request primitive for the Maquina entity.
    	 * @see Maquina the request payload
    	 */
    	String UPDATE_MERGE_MAQUINA = "updateMergeMaquina";
    	/**
    	 * The success response primitive for updateMergeMaquina.
    	 *
    	 * @see #UPDATE_MERGE_MAQUINA the request primitive
    	 */
    	String UPDATE_MERGE_MAQUINA_RESPONSE = "updateMergeMaquinaResponse";
    	/**
    	 * An error response primitive for updateMergeMaquina.
    	 *
    	 * @see #UPDATE_MERGE_MAQUINA the request primitive
    	 */
    	String UPDATE_MERGE_MAQUINA_ERROR = "updateMergeMaquinaError";
    	/**
    	 * The 'delete' request primitive for the Maquina entity.
    	 * @see Maquina.Id the request payload
    	 */
    	String DELETE_MAQUINA = "deleteMaquina";
    	/**
    	 * The success response primitive for deleteMaquina.
    	 *
    	 * @see #DELETE_MAQUINA the request primitive
    	 */
    	String DELETE_MAQUINA_RESPONSE = "deleteMaquinaResponse";
    	/**
    	 * An error response primitive for deleteMaquina.
    	 *
    	 * @see #DELETE_MAQUINA the request primitive
    	 */
    	String DELETE_MAQUINA_ERROR = "deleteMaquinaError";
    	/**
    	 * The 'create' request primitive for the RegistroProducao entity.
    	 * @see RegistroProducao the request payload
    	 */
    	String CREATE_REGISTRO_PRODUCAO = "createRegistroProducao";
    	/**
    	 * The success response primitive for createRegistroProducao.
    	 *
    	 * @see #CREATE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String CREATE_REGISTRO_PRODUCAO_RESPONSE = "createRegistroProducaoResponse";
    	/**
    	 * An error response primitive for createRegistroProducao.
    	 *
    	 * @see #CREATE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String CREATE_REGISTRO_PRODUCAO_ERROR = "createRegistroProducaoError";
    	/**
    	 * The 'createBulk' request primitive for the RegistroProducao entity.
    	 * @see CreateBulkRegistroProducaoInput the request payload
    	 */
    	String CREATE_BULK_REGISTRO_PRODUCAO = "createBulkRegistroProducao";
    	/**
    	 * The success response primitive for createBulkRegistroProducao.
    	 *
    	 * @see #CREATE_BULK_REGISTRO_PRODUCAO the request primitive
    	 * @see CreateBulkRegistroProducaoOutput the response payload
    	 */
    	String CREATE_BULK_REGISTRO_PRODUCAO_RESPONSE = "createBulkRegistroProducaoResponse";
    	/**
    	 * An error response primitive for createBulkRegistroProducao.
    	 *
    	 * @see #CREATE_BULK_REGISTRO_PRODUCAO the request primitive
    	 */
    	String CREATE_BULK_REGISTRO_PRODUCAO_ERROR = "createBulkRegistroProducaoError";
    	/**
    	 * The 'createMerge' request primitive for the RegistroProducao entity.
    	 * @see RegistroProducao the request payload
    	 */
    	String CREATE_MERGE_REGISTRO_PRODUCAO = "createMergeRegistroProducao";
    	/**
    	 * The success response primitive for createMergeRegistroProducao.
    	 *
    	 * @see #CREATE_MERGE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String CREATE_MERGE_REGISTRO_PRODUCAO_RESPONSE = "createMergeRegistroProducaoResponse";
    	/**
    	 * An error response primitive for createMergeRegistroProducao.
    	 *
    	 * @see #CREATE_MERGE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String CREATE_MERGE_REGISTRO_PRODUCAO_ERROR = "createMergeRegistroProducaoError";
    	/**
    	 * The 'retrieve' request primitive for the RegistroProducao entity.
    	 * @see RegistroProducao.GetRequest the request payload
    	 */
    	String RETRIEVE_REGISTRO_PRODUCAO = "retrieveRegistroProducao";
    	/**
    	 * The success response primitive for retrieveRegistroProducao.
    	 *
    	 * @see #RETRIEVE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String RETRIEVE_REGISTRO_PRODUCAO_RESPONSE = "retrieveRegistroProducaoResponse";
    	/**
    	 * An error response primitive for retrieveRegistroProducao.
    	 *
    	 * @see #RETRIEVE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String RETRIEVE_REGISTRO_PRODUCAO_ERROR = "retrieveRegistroProducaoError";
    	/**
    	 * The 'list' request primitive for the RegistroProducao entity.
    	 * @see registroProducao.pageRequest the request payload
    	 */
    	String LIST_REGISTRO_PRODUCAO = "listRegistroProducao";
    	/**
    	 * The success response primitive for listRegistroProducao.
    	 *
    	 * @see #LIST_REGISTRO_PRODUCAO the request primitive
    	 * @see RegistroProducao.PagedResults the response payload
    	 */
    	String LIST_REGISTRO_PRODUCAO_RESPONSE = "listRegistroProducaoResponse";
    	/**
    	 * An error response primitive for listRegistroProducao.
    	 *
    	 * @see #LIST_REGISTRO_PRODUCAO the request primitive
    	 */
    	String LIST_REGISTRO_PRODUCAO_ERROR = "listRegistroProducaoError";
    	/**
    	 * The 'update' request primitive for the RegistroProducao entity.
    	 * @see RegistroProducao the request payload
    	 */
    	String UPDATE_REGISTRO_PRODUCAO = "updateRegistroProducao";
    	/**
    	 * The success response primitive for updateRegistroProducao.
    	 *
    	 * @see #UPDATE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String UPDATE_REGISTRO_PRODUCAO_RESPONSE = "updateRegistroProducaoResponse";
    	/**
    	 * An error response primitive for updateRegistroProducao.
    	 *
    	 * @see #UPDATE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String UPDATE_REGISTRO_PRODUCAO_ERROR = "updateRegistroProducaoError";
    	/**
    	 * The 'updateMerge' request primitive for the RegistroProducao entity.
    	 * @see RegistroProducao the request payload
    	 */
    	String UPDATE_MERGE_REGISTRO_PRODUCAO = "updateMergeRegistroProducao";
    	/**
    	 * The success response primitive for updateMergeRegistroProducao.
    	 *
    	 * @see #UPDATE_MERGE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String UPDATE_MERGE_REGISTRO_PRODUCAO_RESPONSE = "updateMergeRegistroProducaoResponse";
    	/**
    	 * An error response primitive for updateMergeRegistroProducao.
    	 *
    	 * @see #UPDATE_MERGE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String UPDATE_MERGE_REGISTRO_PRODUCAO_ERROR = "updateMergeRegistroProducaoError";
    	/**
    	 * The 'delete' request primitive for the RegistroProducao entity.
    	 * @see RegistroProducao.Id the request payload
    	 */
    	String DELETE_REGISTRO_PRODUCAO = "deleteRegistroProducao";
    	/**
    	 * The success response primitive for deleteRegistroProducao.
    	 *
    	 * @see #DELETE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String DELETE_REGISTRO_PRODUCAO_RESPONSE = "deleteRegistroProducaoResponse";
    	/**
    	 * An error response primitive for deleteRegistroProducao.
    	 *
    	 * @see #DELETE_REGISTRO_PRODUCAO the request primitive
    	 */
    	String DELETE_REGISTRO_PRODUCAO_ERROR = "deleteRegistroProducaoError";
    }
    
    interface Events {
    	/**
    	 * Default 'serviceStarted' event.
    	 */
    	String SERVICE_STARTED = "serviceStarted";
    	/**
    	 * Default 'notifyUser' event.
    	 */
    	String NOTIFY_USER_EVENT = "notifyUserEvent";
    	String IMPORT_PECA_EVENT = "importPecaEvent";
    	String EXPORT_PECA_EVENT = "exportPecaEvent";
    	String IMPORT_FUNCIONARIO_EVENT = "importFuncionarioEvent";
    	String EXPORT_FUNCIONARIO_EVENT = "exportFuncionarioEvent";
    	String IMPORT_MAQUINA_EVENT = "importMaquinaEvent";
    	String EXPORT_MAQUINA_EVENT = "exportMaquinaEvent";
    	String IMPORT_REGISTRO_PRODUCAO_EVENT = "importRegistroProducaoEvent";
    	String EXPORT_REGISTRO_PRODUCAO_EVENT = "exportRegistroProducaoEvent";
    }
    
}
