/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import br.com.senior.messaging.*;
import br.com.senior.messaging.utils.DtoJsonConverter;
import br.com.senior.sdl.user.UserIdentifier;

import java.util.concurrent.CompletableFuture;


/**
* 
*/
@SuppressWarnings("deprecation") // To prevent warnings in generated code about known deprecated methods.
public class MyServiceStubImpl  implements MyServiceStub {

	protected final Supplier<IMessenger> messengerSupplier;
	protected final UserIdentifier userId;
	protected final Supplier<Message> messageSupplier;

	/**
	 * Use {@link #MyServiceStubImpl(MessengerSupplier, UserIdentifier, MessageSupplier)} instead.
	 */
	@Deprecated
	public MyServiceStubImpl(IMessenger messenger, UserIdentifier userId) {
		this(new br.com.senior.mydomain.myservice.InstanceMessengerSupplier(messenger), userId, null);
	}

	/**
	 * @param messengerSupplier Supplies current service messenger.
	 * @param userId Provides tenant and user name to send or publish messages.
	 * @param messageSupplier Supplies current message being processed by service. Used to send messages by foolowup.
	 */
	public MyServiceStubImpl(Supplier<IMessenger> messengerSupplier, UserIdentifier userId, Supplier<Message> messageSupplier) {
		this.messengerSupplier = messengerSupplier;
		this.userId = userId;
		this.messageSupplier = messageSupplier;
	}

	/**
	 * Chamada síncrona para o método helloWorld
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public HelloWorldOutput helloWorld(HelloWorldInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.HelloWorldImpl impl = new br.com.senior.mydomain.myservice.impl.HelloWorldImpl(messengerSupplier, userId, messageSupplier);
		return impl.helloWorld(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método helloWorld
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void helloWorld(HelloWorldInput input) {
		br.com.senior.mydomain.myservice.impl.HelloWorldImpl impl = new br.com.senior.mydomain.myservice.impl.HelloWorldImpl(messengerSupplier, userId, messageSupplier);
		impl.helloWorld(input);
	}
	
	/**
	 * Chamada assíncrona para o método helloWorld
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<HelloWorldOutput> helloWorldRequest(HelloWorldInput input) {
		return this.helloWorldRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método helloWorld
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<HelloWorldOutput> helloWorldRequest(HelloWorldInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.HelloWorldImpl impl = new br.com.senior.mydomain.myservice.impl.HelloWorldImpl(messengerSupplier, userId, messageSupplier);
		return impl.helloWorldRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método getMetadata
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public GetMetadataOutput getMetadata(GetMetadataInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.GetMetadataImpl impl = new br.com.senior.mydomain.myservice.impl.GetMetadataImpl(messengerSupplier, userId, messageSupplier);
		return impl.getMetadata(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método getMetadata
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 */
	@Override
	public void getMetadata(GetMetadataInput input) {
		br.com.senior.mydomain.myservice.impl.GetMetadataImpl impl = new br.com.senior.mydomain.myservice.impl.GetMetadataImpl(messengerSupplier, userId, messageSupplier);
		impl.getMetadata(input);
	}
	
	/**
	 * Chamada assíncrona para o método getMetadata
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 */
	@Override
	public CompletableFuture<GetMetadataOutput> getMetadataRequest(GetMetadataInput input) {
		return this.getMetadataRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método getMetadata
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	*/
	@Override
	public CompletableFuture<GetMetadataOutput> getMetadataRequest(GetMetadataInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.GetMetadataImpl impl = new br.com.senior.mydomain.myservice.impl.GetMetadataImpl(messengerSupplier, userId, messageSupplier);
		return impl.getMetadataRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método importPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ImportPecaOutput importPeca(ImportPecaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ImportPecaImpl impl = new br.com.senior.mydomain.myservice.impl.ImportPecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.importPeca(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método importPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void importPeca(ImportPecaInput input) {
		br.com.senior.mydomain.myservice.impl.ImportPecaImpl impl = new br.com.senior.mydomain.myservice.impl.ImportPecaImpl(messengerSupplier, userId, messageSupplier);
		impl.importPeca(input);
	}
	
	/**
	 * Chamada assíncrona para o método importPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ImportPecaOutput> importPecaRequest(ImportPecaInput input) {
		return this.importPecaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método importPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ImportPecaOutput> importPecaRequest(ImportPecaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ImportPecaImpl impl = new br.com.senior.mydomain.myservice.impl.ImportPecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.importPecaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método exportPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ExportPecaOutput exportPeca(ExportPecaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ExportPecaImpl impl = new br.com.senior.mydomain.myservice.impl.ExportPecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportPeca(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método exportPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void exportPeca(ExportPecaInput input) {
		br.com.senior.mydomain.myservice.impl.ExportPecaImpl impl = new br.com.senior.mydomain.myservice.impl.ExportPecaImpl(messengerSupplier, userId, messageSupplier);
		impl.exportPeca(input);
	}
	
	/**
	 * Chamada assíncrona para o método exportPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ExportPecaOutput> exportPecaRequest(ExportPecaInput input) {
		return this.exportPecaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método exportPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ExportPecaOutput> exportPecaRequest(ExportPecaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ExportPecaImpl impl = new br.com.senior.mydomain.myservice.impl.ExportPecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportPecaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método importFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ImportFuncionarioOutput importFuncionario(ImportFuncionarioInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ImportFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.ImportFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.importFuncionario(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método importFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void importFuncionario(ImportFuncionarioInput input) {
		br.com.senior.mydomain.myservice.impl.ImportFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.ImportFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		impl.importFuncionario(input);
	}
	
	/**
	 * Chamada assíncrona para o método importFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ImportFuncionarioOutput> importFuncionarioRequest(ImportFuncionarioInput input) {
		return this.importFuncionarioRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método importFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ImportFuncionarioOutput> importFuncionarioRequest(ImportFuncionarioInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ImportFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.ImportFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.importFuncionarioRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método exportFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ExportFuncionarioOutput exportFuncionario(ExportFuncionarioInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ExportFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.ExportFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportFuncionario(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método exportFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void exportFuncionario(ExportFuncionarioInput input) {
		br.com.senior.mydomain.myservice.impl.ExportFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.ExportFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		impl.exportFuncionario(input);
	}
	
	/**
	 * Chamada assíncrona para o método exportFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ExportFuncionarioOutput> exportFuncionarioRequest(ExportFuncionarioInput input) {
		return this.exportFuncionarioRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método exportFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ExportFuncionarioOutput> exportFuncionarioRequest(ExportFuncionarioInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ExportFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.ExportFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportFuncionarioRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método importMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ImportMaquinaOutput importMaquina(ImportMaquinaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ImportMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.ImportMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.importMaquina(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método importMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void importMaquina(ImportMaquinaInput input) {
		br.com.senior.mydomain.myservice.impl.ImportMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.ImportMaquinaImpl(messengerSupplier, userId, messageSupplier);
		impl.importMaquina(input);
	}
	
	/**
	 * Chamada assíncrona para o método importMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ImportMaquinaOutput> importMaquinaRequest(ImportMaquinaInput input) {
		return this.importMaquinaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método importMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ImportMaquinaOutput> importMaquinaRequest(ImportMaquinaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ImportMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.ImportMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.importMaquinaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método exportMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ExportMaquinaOutput exportMaquina(ExportMaquinaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ExportMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.ExportMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportMaquina(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método exportMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void exportMaquina(ExportMaquinaInput input) {
		br.com.senior.mydomain.myservice.impl.ExportMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.ExportMaquinaImpl(messengerSupplier, userId, messageSupplier);
		impl.exportMaquina(input);
	}
	
	/**
	 * Chamada assíncrona para o método exportMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ExportMaquinaOutput> exportMaquinaRequest(ExportMaquinaInput input) {
		return this.exportMaquinaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método exportMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ExportMaquinaOutput> exportMaquinaRequest(ExportMaquinaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ExportMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.ExportMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportMaquinaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método importRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ImportRegistro_producaoOutput importRegistro_producao(ImportRegistro_producaoInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ImportRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.ImportRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.importRegistro_producao(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método importRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void importRegistro_producao(ImportRegistro_producaoInput input) {
		br.com.senior.mydomain.myservice.impl.ImportRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.ImportRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		impl.importRegistro_producao(input);
	}
	
	/**
	 * Chamada assíncrona para o método importRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ImportRegistro_producaoOutput> importRegistro_producaoRequest(ImportRegistro_producaoInput input) {
		return this.importRegistro_producaoRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método importRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ImportRegistro_producaoOutput> importRegistro_producaoRequest(ImportRegistro_producaoInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ImportRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.ImportRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.importRegistro_producaoRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método exportRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ExportRegistro_producaoOutput exportRegistro_producao(ExportRegistro_producaoInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ExportRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.ExportRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportRegistro_producao(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método exportRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void exportRegistro_producao(ExportRegistro_producaoInput input) {
		br.com.senior.mydomain.myservice.impl.ExportRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.ExportRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		impl.exportRegistro_producao(input);
	}
	
	/**
	 * Chamada assíncrona para o método exportRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ExportRegistro_producaoOutput> exportRegistro_producaoRequest(ExportRegistro_producaoInput input) {
		return this.exportRegistro_producaoRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método exportRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ExportRegistro_producaoOutput> exportRegistro_producaoRequest(ExportRegistro_producaoInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ExportRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.ExportRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportRegistro_producaoRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método getDependencies
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public GetDependenciesOutput getDependencies(long timeout) {
		br.com.senior.mydomain.myservice.impl.GetDependenciesImpl impl = new br.com.senior.mydomain.myservice.impl.GetDependenciesImpl(messengerSupplier, userId, messageSupplier);
		return impl.getDependencies(timeout);
	}
	
	/**
	 * Chamada assíncrona para o método getDependencies
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 */
	@Override
	public void getDependencies() {
		br.com.senior.mydomain.myservice.impl.GetDependenciesImpl impl = new br.com.senior.mydomain.myservice.impl.GetDependenciesImpl(messengerSupplier, userId, messageSupplier);
		impl.getDependencies();
	}
	
	/**
	 * Chamada assíncrona para o método getDependencies
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 */
	@Override
	public CompletableFuture<GetDependenciesOutput> getDependenciesRequest() {
		return this.getDependenciesRequest(0l);
	}
	
	/**
	 * Chamada assíncrona para o método getDependencies
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	*/
	@Override
	public CompletableFuture<GetDependenciesOutput> getDependenciesRequest(long timeout) {
		br.com.senior.mydomain.myservice.impl.GetDependenciesImpl impl = new br.com.senior.mydomain.myservice.impl.GetDependenciesImpl(messengerSupplier, userId, messageSupplier);
		return impl.getDependenciesRequest(timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createPeca
	 * This is a public operation
	 * The 'create' request primitive for the Peca entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Peca createPeca(Peca input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreatePecaImpl impl = new br.com.senior.mydomain.myservice.impl.CreatePecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createPeca(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createPeca
	 * This is a public operation
	 * The 'create' request primitive for the Peca entity.
	 */
	@Override
	public void createPeca(Peca input) {
		br.com.senior.mydomain.myservice.impl.CreatePecaImpl impl = new br.com.senior.mydomain.myservice.impl.CreatePecaImpl(messengerSupplier, userId, messageSupplier);
		impl.createPeca(input);
	}
	
	/**
	 * Chamada assíncrona para o método createPeca
	 * This is a public operation
	 * The 'create' request primitive for the Peca entity.
	 */
	@Override
	public CompletableFuture<Peca> createPecaRequest(Peca input) {
		return this.createPecaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createPeca
	 * This is a public operation
	 * The 'create' request primitive for the Peca entity.
	*/
	@Override
	public CompletableFuture<Peca> createPecaRequest(Peca input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreatePecaImpl impl = new br.com.senior.mydomain.myservice.impl.CreatePecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createPecaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createBulkPeca
	 * This is a public operation
	 * The 'createBulk' request primitive for the Peca entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public CreateBulkPecaOutput createBulkPeca(CreateBulkPecaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateBulkPecaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkPecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkPeca(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkPeca
	 * This is a public operation
	 * The 'createBulk' request primitive for the Peca entity.
	 */
	@Override
	public void createBulkPeca(CreateBulkPecaInput input) {
		br.com.senior.mydomain.myservice.impl.CreateBulkPecaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkPecaImpl(messengerSupplier, userId, messageSupplier);
		impl.createBulkPeca(input);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkPeca
	 * This is a public operation
	 * The 'createBulk' request primitive for the Peca entity.
	 */
	@Override
	public CompletableFuture<CreateBulkPecaOutput> createBulkPecaRequest(CreateBulkPecaInput input) {
		return this.createBulkPecaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkPeca
	 * This is a public operation
	 * The 'createBulk' request primitive for the Peca entity.
	*/
	@Override
	public CompletableFuture<CreateBulkPecaOutput> createBulkPecaRequest(CreateBulkPecaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateBulkPecaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkPecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkPecaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createMergePeca
	 * This is a public operation
	 * The 'createMerge' request primitive for the Peca entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Peca createMergePeca(Peca input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateMergePecaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergePecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergePeca(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMergePeca
	 * This is a public operation
	 * The 'createMerge' request primitive for the Peca entity.
	 */
	@Override
	public void createMergePeca(Peca input) {
		br.com.senior.mydomain.myservice.impl.CreateMergePecaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergePecaImpl(messengerSupplier, userId, messageSupplier);
		impl.createMergePeca(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMergePeca
	 * This is a public operation
	 * The 'createMerge' request primitive for the Peca entity.
	 */
	@Override
	public CompletableFuture<Peca> createMergePecaRequest(Peca input) {
		return this.createMergePecaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createMergePeca
	 * This is a public operation
	 * The 'createMerge' request primitive for the Peca entity.
	*/
	@Override
	public CompletableFuture<Peca> createMergePecaRequest(Peca input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateMergePecaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergePecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergePecaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método retrievePeca
	 * This is a public operation
	 * The 'retrieve' request primitive for the Peca entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Peca retrievePeca(Peca.GetRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.RetrievePecaImpl impl = new br.com.senior.mydomain.myservice.impl.RetrievePecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrievePeca(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método retrievePeca
	 * This is a public operation
	 * The 'retrieve' request primitive for the Peca entity.
	 */
	@Override
	public void retrievePeca(Peca.GetRequest input) {
		br.com.senior.mydomain.myservice.impl.RetrievePecaImpl impl = new br.com.senior.mydomain.myservice.impl.RetrievePecaImpl(messengerSupplier, userId, messageSupplier);
		impl.retrievePeca(input);
	}
	
	/**
	 * Chamada assíncrona para o método retrievePeca
	 * This is a public operation
	 * The 'retrieve' request primitive for the Peca entity.
	 */
	@Override
	public CompletableFuture<Peca> retrievePecaRequest(Peca.GetRequest input) {
		return this.retrievePecaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método retrievePeca
	 * This is a public operation
	 * The 'retrieve' request primitive for the Peca entity.
	*/
	@Override
	public CompletableFuture<Peca> retrievePecaRequest(Peca.GetRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.RetrievePecaImpl impl = new br.com.senior.mydomain.myservice.impl.RetrievePecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrievePecaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método listPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Peca entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Peca.PagedResults listPeca(Peca.PageRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ListPecaImpl impl = new br.com.senior.mydomain.myservice.impl.ListPecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.listPeca(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método listPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Peca entity.
	 */
	@Override
	public void listPeca(Peca.PageRequest input) {
		br.com.senior.mydomain.myservice.impl.ListPecaImpl impl = new br.com.senior.mydomain.myservice.impl.ListPecaImpl(messengerSupplier, userId, messageSupplier);
		impl.listPeca(input);
	}
	
	/**
	 * Chamada assíncrona para o método listPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Peca entity.
	 */
	@Override
	public CompletableFuture<Peca.PagedResults> listPecaRequest(Peca.PageRequest input) {
		return this.listPecaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método listPeca
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Peca entity.
	*/
	@Override
	public CompletableFuture<Peca.PagedResults> listPecaRequest(Peca.PageRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ListPecaImpl impl = new br.com.senior.mydomain.myservice.impl.ListPecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.listPecaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updatePeca
	 * This is a public operation
	 * The 'update' request primitive for the Peca entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Peca updatePeca(Peca input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdatePecaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdatePecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.updatePeca(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updatePeca
	 * This is a public operation
	 * The 'update' request primitive for the Peca entity.
	 */
	@Override
	public void updatePeca(Peca input) {
		br.com.senior.mydomain.myservice.impl.UpdatePecaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdatePecaImpl(messengerSupplier, userId, messageSupplier);
		impl.updatePeca(input);
	}
	
	/**
	 * Chamada assíncrona para o método updatePeca
	 * This is a public operation
	 * The 'update' request primitive for the Peca entity.
	 */
	@Override
	public CompletableFuture<Peca> updatePecaRequest(Peca input) {
		return this.updatePecaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updatePeca
	 * This is a public operation
	 * The 'update' request primitive for the Peca entity.
	*/
	@Override
	public CompletableFuture<Peca> updatePecaRequest(Peca input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdatePecaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdatePecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.updatePecaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateMergePeca
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Peca entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Peca updateMergePeca(Peca input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateMergePecaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergePecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergePeca(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergePeca
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Peca entity.
	 */
	@Override
	public void updateMergePeca(Peca input) {
		br.com.senior.mydomain.myservice.impl.UpdateMergePecaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergePecaImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMergePeca(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergePeca
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Peca entity.
	 */
	@Override
	public CompletableFuture<Peca> updateMergePecaRequest(Peca input) {
		return this.updateMergePecaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergePeca
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Peca entity.
	*/
	@Override
	public CompletableFuture<Peca> updateMergePecaRequest(Peca input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateMergePecaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergePecaImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergePecaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método deletePeca
	 * This is a public operation
	 * The 'delete' request primitive for the Peca entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public void deletePeca(Peca.Id input, long timeout) {
		br.com.senior.mydomain.myservice.impl.DeletePecaImpl impl = new br.com.senior.mydomain.myservice.impl.DeletePecaImpl(messengerSupplier, userId, messageSupplier);
		impl.deletePeca(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método deletePeca
	 * This is a public operation
	 * The 'delete' request primitive for the Peca entity.
	 */
	@Override
	public void deletePeca(Peca.Id input) {
		br.com.senior.mydomain.myservice.impl.DeletePecaImpl impl = new br.com.senior.mydomain.myservice.impl.DeletePecaImpl(messengerSupplier, userId, messageSupplier);
		impl.deletePeca(input);
	}
	
	
	/**
	 * Chamada síncrona para o método createFuncionario
	 * This is a public operation
	 * The 'create' request primitive for the Funcionario entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Funcionario createFuncionario(Funcionario input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.CreateFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.createFuncionario(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createFuncionario
	 * This is a public operation
	 * The 'create' request primitive for the Funcionario entity.
	 */
	@Override
	public void createFuncionario(Funcionario input) {
		br.com.senior.mydomain.myservice.impl.CreateFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.CreateFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		impl.createFuncionario(input);
	}
	
	/**
	 * Chamada assíncrona para o método createFuncionario
	 * This is a public operation
	 * The 'create' request primitive for the Funcionario entity.
	 */
	@Override
	public CompletableFuture<Funcionario> createFuncionarioRequest(Funcionario input) {
		return this.createFuncionarioRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createFuncionario
	 * This is a public operation
	 * The 'create' request primitive for the Funcionario entity.
	*/
	@Override
	public CompletableFuture<Funcionario> createFuncionarioRequest(Funcionario input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.CreateFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.createFuncionarioRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createBulkFuncionario
	 * This is a public operation
	 * The 'createBulk' request primitive for the Funcionario entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public CreateBulkFuncionarioOutput createBulkFuncionario(CreateBulkFuncionarioInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateBulkFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkFuncionario(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkFuncionario
	 * This is a public operation
	 * The 'createBulk' request primitive for the Funcionario entity.
	 */
	@Override
	public void createBulkFuncionario(CreateBulkFuncionarioInput input) {
		br.com.senior.mydomain.myservice.impl.CreateBulkFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		impl.createBulkFuncionario(input);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkFuncionario
	 * This is a public operation
	 * The 'createBulk' request primitive for the Funcionario entity.
	 */
	@Override
	public CompletableFuture<CreateBulkFuncionarioOutput> createBulkFuncionarioRequest(CreateBulkFuncionarioInput input) {
		return this.createBulkFuncionarioRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkFuncionario
	 * This is a public operation
	 * The 'createBulk' request primitive for the Funcionario entity.
	*/
	@Override
	public CompletableFuture<CreateBulkFuncionarioOutput> createBulkFuncionarioRequest(CreateBulkFuncionarioInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateBulkFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkFuncionarioRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createMergeFuncionario
	 * This is a public operation
	 * The 'createMerge' request primitive for the Funcionario entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Funcionario createMergeFuncionario(Funcionario input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateMergeFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergeFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeFuncionario(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeFuncionario
	 * This is a public operation
	 * The 'createMerge' request primitive for the Funcionario entity.
	 */
	@Override
	public void createMergeFuncionario(Funcionario input) {
		br.com.senior.mydomain.myservice.impl.CreateMergeFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergeFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		impl.createMergeFuncionario(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeFuncionario
	 * This is a public operation
	 * The 'createMerge' request primitive for the Funcionario entity.
	 */
	@Override
	public CompletableFuture<Funcionario> createMergeFuncionarioRequest(Funcionario input) {
		return this.createMergeFuncionarioRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeFuncionario
	 * This is a public operation
	 * The 'createMerge' request primitive for the Funcionario entity.
	*/
	@Override
	public CompletableFuture<Funcionario> createMergeFuncionarioRequest(Funcionario input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateMergeFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergeFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeFuncionarioRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método retrieveFuncionario
	 * This is a public operation
	 * The 'retrieve' request primitive for the Funcionario entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Funcionario retrieveFuncionario(Funcionario.GetRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.RetrieveFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.RetrieveFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveFuncionario(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveFuncionario
	 * This is a public operation
	 * The 'retrieve' request primitive for the Funcionario entity.
	 */
	@Override
	public void retrieveFuncionario(Funcionario.GetRequest input) {
		br.com.senior.mydomain.myservice.impl.RetrieveFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.RetrieveFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		impl.retrieveFuncionario(input);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveFuncionario
	 * This is a public operation
	 * The 'retrieve' request primitive for the Funcionario entity.
	 */
	@Override
	public CompletableFuture<Funcionario> retrieveFuncionarioRequest(Funcionario.GetRequest input) {
		return this.retrieveFuncionarioRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveFuncionario
	 * This is a public operation
	 * The 'retrieve' request primitive for the Funcionario entity.
	*/
	@Override
	public CompletableFuture<Funcionario> retrieveFuncionarioRequest(Funcionario.GetRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.RetrieveFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.RetrieveFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveFuncionarioRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método listFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Funcionario entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Funcionario.PagedResults listFuncionario(Funcionario.PageRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ListFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.ListFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.listFuncionario(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método listFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Funcionario entity.
	 */
	@Override
	public void listFuncionario(Funcionario.PageRequest input) {
		br.com.senior.mydomain.myservice.impl.ListFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.ListFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		impl.listFuncionario(input);
	}
	
	/**
	 * Chamada assíncrona para o método listFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Funcionario entity.
	 */
	@Override
	public CompletableFuture<Funcionario.PagedResults> listFuncionarioRequest(Funcionario.PageRequest input) {
		return this.listFuncionarioRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método listFuncionario
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Funcionario entity.
	*/
	@Override
	public CompletableFuture<Funcionario.PagedResults> listFuncionarioRequest(Funcionario.PageRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ListFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.ListFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.listFuncionarioRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateFuncionario
	 * This is a public operation
	 * The 'update' request primitive for the Funcionario entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Funcionario updateFuncionario(Funcionario input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateFuncionario(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateFuncionario
	 * This is a public operation
	 * The 'update' request primitive for the Funcionario entity.
	 */
	@Override
	public void updateFuncionario(Funcionario input) {
		br.com.senior.mydomain.myservice.impl.UpdateFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		impl.updateFuncionario(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateFuncionario
	 * This is a public operation
	 * The 'update' request primitive for the Funcionario entity.
	 */
	@Override
	public CompletableFuture<Funcionario> updateFuncionarioRequest(Funcionario input) {
		return this.updateFuncionarioRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateFuncionario
	 * This is a public operation
	 * The 'update' request primitive for the Funcionario entity.
	*/
	@Override
	public CompletableFuture<Funcionario> updateFuncionarioRequest(Funcionario input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateFuncionarioRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateMergeFuncionario
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Funcionario entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Funcionario updateMergeFuncionario(Funcionario input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateMergeFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergeFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeFuncionario(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeFuncionario
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Funcionario entity.
	 */
	@Override
	public void updateMergeFuncionario(Funcionario input) {
		br.com.senior.mydomain.myservice.impl.UpdateMergeFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergeFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMergeFuncionario(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeFuncionario
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Funcionario entity.
	 */
	@Override
	public CompletableFuture<Funcionario> updateMergeFuncionarioRequest(Funcionario input) {
		return this.updateMergeFuncionarioRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeFuncionario
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Funcionario entity.
	*/
	@Override
	public CompletableFuture<Funcionario> updateMergeFuncionarioRequest(Funcionario input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateMergeFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergeFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeFuncionarioRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método deleteFuncionario
	 * This is a public operation
	 * The 'delete' request primitive for the Funcionario entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public void deleteFuncionario(Funcionario.Id input, long timeout) {
		br.com.senior.mydomain.myservice.impl.DeleteFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.DeleteFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteFuncionario(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método deleteFuncionario
	 * This is a public operation
	 * The 'delete' request primitive for the Funcionario entity.
	 */
	@Override
	public void deleteFuncionario(Funcionario.Id input) {
		br.com.senior.mydomain.myservice.impl.DeleteFuncionarioImpl impl = new br.com.senior.mydomain.myservice.impl.DeleteFuncionarioImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteFuncionario(input);
	}
	
	
	/**
	 * Chamada síncrona para o método createMaquina
	 * This is a public operation
	 * The 'create' request primitive for the Maquina entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Maquina createMaquina(Maquina input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMaquina(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMaquina
	 * This is a public operation
	 * The 'create' request primitive for the Maquina entity.
	 */
	@Override
	public void createMaquina(Maquina input) {
		br.com.senior.mydomain.myservice.impl.CreateMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMaquinaImpl(messengerSupplier, userId, messageSupplier);
		impl.createMaquina(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMaquina
	 * This is a public operation
	 * The 'create' request primitive for the Maquina entity.
	 */
	@Override
	public CompletableFuture<Maquina> createMaquinaRequest(Maquina input) {
		return this.createMaquinaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createMaquina
	 * This is a public operation
	 * The 'create' request primitive for the Maquina entity.
	*/
	@Override
	public CompletableFuture<Maquina> createMaquinaRequest(Maquina input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMaquinaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createBulkMaquina
	 * This is a public operation
	 * The 'createBulk' request primitive for the Maquina entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public CreateBulkMaquinaOutput createBulkMaquina(CreateBulkMaquinaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateBulkMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkMaquina(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkMaquina
	 * This is a public operation
	 * The 'createBulk' request primitive for the Maquina entity.
	 */
	@Override
	public void createBulkMaquina(CreateBulkMaquinaInput input) {
		br.com.senior.mydomain.myservice.impl.CreateBulkMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkMaquinaImpl(messengerSupplier, userId, messageSupplier);
		impl.createBulkMaquina(input);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkMaquina
	 * This is a public operation
	 * The 'createBulk' request primitive for the Maquina entity.
	 */
	@Override
	public CompletableFuture<CreateBulkMaquinaOutput> createBulkMaquinaRequest(CreateBulkMaquinaInput input) {
		return this.createBulkMaquinaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkMaquina
	 * This is a public operation
	 * The 'createBulk' request primitive for the Maquina entity.
	*/
	@Override
	public CompletableFuture<CreateBulkMaquinaOutput> createBulkMaquinaRequest(CreateBulkMaquinaInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateBulkMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkMaquinaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createMergeMaquina
	 * This is a public operation
	 * The 'createMerge' request primitive for the Maquina entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Maquina createMergeMaquina(Maquina input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateMergeMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergeMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeMaquina(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeMaquina
	 * This is a public operation
	 * The 'createMerge' request primitive for the Maquina entity.
	 */
	@Override
	public void createMergeMaquina(Maquina input) {
		br.com.senior.mydomain.myservice.impl.CreateMergeMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergeMaquinaImpl(messengerSupplier, userId, messageSupplier);
		impl.createMergeMaquina(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeMaquina
	 * This is a public operation
	 * The 'createMerge' request primitive for the Maquina entity.
	 */
	@Override
	public CompletableFuture<Maquina> createMergeMaquinaRequest(Maquina input) {
		return this.createMergeMaquinaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeMaquina
	 * This is a public operation
	 * The 'createMerge' request primitive for the Maquina entity.
	*/
	@Override
	public CompletableFuture<Maquina> createMergeMaquinaRequest(Maquina input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateMergeMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergeMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeMaquinaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método retrieveMaquina
	 * This is a public operation
	 * The 'retrieve' request primitive for the Maquina entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Maquina retrieveMaquina(Maquina.GetRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.RetrieveMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.RetrieveMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveMaquina(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveMaquina
	 * This is a public operation
	 * The 'retrieve' request primitive for the Maquina entity.
	 */
	@Override
	public void retrieveMaquina(Maquina.GetRequest input) {
		br.com.senior.mydomain.myservice.impl.RetrieveMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.RetrieveMaquinaImpl(messengerSupplier, userId, messageSupplier);
		impl.retrieveMaquina(input);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveMaquina
	 * This is a public operation
	 * The 'retrieve' request primitive for the Maquina entity.
	 */
	@Override
	public CompletableFuture<Maquina> retrieveMaquinaRequest(Maquina.GetRequest input) {
		return this.retrieveMaquinaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveMaquina
	 * This is a public operation
	 * The 'retrieve' request primitive for the Maquina entity.
	*/
	@Override
	public CompletableFuture<Maquina> retrieveMaquinaRequest(Maquina.GetRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.RetrieveMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.RetrieveMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveMaquinaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método listMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Maquina entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Maquina.PagedResults listMaquina(Maquina.PageRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ListMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.ListMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.listMaquina(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método listMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Maquina entity.
	 */
	@Override
	public void listMaquina(Maquina.PageRequest input) {
		br.com.senior.mydomain.myservice.impl.ListMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.ListMaquinaImpl(messengerSupplier, userId, messageSupplier);
		impl.listMaquina(input);
	}
	
	/**
	 * Chamada assíncrona para o método listMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Maquina entity.
	 */
	@Override
	public CompletableFuture<Maquina.PagedResults> listMaquinaRequest(Maquina.PageRequest input) {
		return this.listMaquinaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método listMaquina
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Maquina entity.
	*/
	@Override
	public CompletableFuture<Maquina.PagedResults> listMaquinaRequest(Maquina.PageRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ListMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.ListMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.listMaquinaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateMaquina
	 * This is a public operation
	 * The 'update' request primitive for the Maquina entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Maquina updateMaquina(Maquina input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMaquina(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMaquina
	 * This is a public operation
	 * The 'update' request primitive for the Maquina entity.
	 */
	@Override
	public void updateMaquina(Maquina input) {
		br.com.senior.mydomain.myservice.impl.UpdateMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMaquinaImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMaquina(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMaquina
	 * This is a public operation
	 * The 'update' request primitive for the Maquina entity.
	 */
	@Override
	public CompletableFuture<Maquina> updateMaquinaRequest(Maquina input) {
		return this.updateMaquinaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateMaquina
	 * This is a public operation
	 * The 'update' request primitive for the Maquina entity.
	*/
	@Override
	public CompletableFuture<Maquina> updateMaquinaRequest(Maquina input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMaquinaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateMergeMaquina
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Maquina entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Maquina updateMergeMaquina(Maquina input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateMergeMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergeMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeMaquina(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeMaquina
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Maquina entity.
	 */
	@Override
	public void updateMergeMaquina(Maquina input) {
		br.com.senior.mydomain.myservice.impl.UpdateMergeMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergeMaquinaImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMergeMaquina(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeMaquina
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Maquina entity.
	 */
	@Override
	public CompletableFuture<Maquina> updateMergeMaquinaRequest(Maquina input) {
		return this.updateMergeMaquinaRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeMaquina
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Maquina entity.
	*/
	@Override
	public CompletableFuture<Maquina> updateMergeMaquinaRequest(Maquina input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateMergeMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergeMaquinaImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeMaquinaRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método deleteMaquina
	 * This is a public operation
	 * The 'delete' request primitive for the Maquina entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public void deleteMaquina(Maquina.Id input, long timeout) {
		br.com.senior.mydomain.myservice.impl.DeleteMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.DeleteMaquinaImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteMaquina(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método deleteMaquina
	 * This is a public operation
	 * The 'delete' request primitive for the Maquina entity.
	 */
	@Override
	public void deleteMaquina(Maquina.Id input) {
		br.com.senior.mydomain.myservice.impl.DeleteMaquinaImpl impl = new br.com.senior.mydomain.myservice.impl.DeleteMaquinaImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteMaquina(input);
	}
	
	
	/**
	 * Chamada síncrona para o método createRegistro_producao
	 * This is a public operation
	 * The 'create' request primitive for the Registro_producao entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Registro_producao createRegistro_producao(Registro_producao input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.CreateRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.createRegistro_producao(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createRegistro_producao
	 * This is a public operation
	 * The 'create' request primitive for the Registro_producao entity.
	 */
	@Override
	public void createRegistro_producao(Registro_producao input) {
		br.com.senior.mydomain.myservice.impl.CreateRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.CreateRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		impl.createRegistro_producao(input);
	}
	
	/**
	 * Chamada assíncrona para o método createRegistro_producao
	 * This is a public operation
	 * The 'create' request primitive for the Registro_producao entity.
	 */
	@Override
	public CompletableFuture<Registro_producao> createRegistro_producaoRequest(Registro_producao input) {
		return this.createRegistro_producaoRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createRegistro_producao
	 * This is a public operation
	 * The 'create' request primitive for the Registro_producao entity.
	*/
	@Override
	public CompletableFuture<Registro_producao> createRegistro_producaoRequest(Registro_producao input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.CreateRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.createRegistro_producaoRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createBulkRegistro_producao
	 * This is a public operation
	 * The 'createBulk' request primitive for the Registro_producao entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public CreateBulkRegistro_producaoOutput createBulkRegistro_producao(CreateBulkRegistro_producaoInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateBulkRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkRegistro_producao(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkRegistro_producao
	 * This is a public operation
	 * The 'createBulk' request primitive for the Registro_producao entity.
	 */
	@Override
	public void createBulkRegistro_producao(CreateBulkRegistro_producaoInput input) {
		br.com.senior.mydomain.myservice.impl.CreateBulkRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		impl.createBulkRegistro_producao(input);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkRegistro_producao
	 * This is a public operation
	 * The 'createBulk' request primitive for the Registro_producao entity.
	 */
	@Override
	public CompletableFuture<CreateBulkRegistro_producaoOutput> createBulkRegistro_producaoRequest(CreateBulkRegistro_producaoInput input) {
		return this.createBulkRegistro_producaoRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkRegistro_producao
	 * This is a public operation
	 * The 'createBulk' request primitive for the Registro_producao entity.
	*/
	@Override
	public CompletableFuture<CreateBulkRegistro_producaoOutput> createBulkRegistro_producaoRequest(CreateBulkRegistro_producaoInput input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateBulkRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.CreateBulkRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkRegistro_producaoRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createMergeRegistro_producao
	 * This is a public operation
	 * The 'createMerge' request primitive for the Registro_producao entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Registro_producao createMergeRegistro_producao(Registro_producao input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateMergeRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergeRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeRegistro_producao(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeRegistro_producao
	 * This is a public operation
	 * The 'createMerge' request primitive for the Registro_producao entity.
	 */
	@Override
	public void createMergeRegistro_producao(Registro_producao input) {
		br.com.senior.mydomain.myservice.impl.CreateMergeRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergeRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		impl.createMergeRegistro_producao(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeRegistro_producao
	 * This is a public operation
	 * The 'createMerge' request primitive for the Registro_producao entity.
	 */
	@Override
	public CompletableFuture<Registro_producao> createMergeRegistro_producaoRequest(Registro_producao input) {
		return this.createMergeRegistro_producaoRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeRegistro_producao
	 * This is a public operation
	 * The 'createMerge' request primitive for the Registro_producao entity.
	*/
	@Override
	public CompletableFuture<Registro_producao> createMergeRegistro_producaoRequest(Registro_producao input, long timeout) {
		br.com.senior.mydomain.myservice.impl.CreateMergeRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.CreateMergeRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeRegistro_producaoRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método retrieveRegistro_producao
	 * This is a public operation
	 * The 'retrieve' request primitive for the Registro_producao entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Registro_producao retrieveRegistro_producao(Registro_producao.GetRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.RetrieveRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.RetrieveRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveRegistro_producao(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveRegistro_producao
	 * This is a public operation
	 * The 'retrieve' request primitive for the Registro_producao entity.
	 */
	@Override
	public void retrieveRegistro_producao(Registro_producao.GetRequest input) {
		br.com.senior.mydomain.myservice.impl.RetrieveRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.RetrieveRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		impl.retrieveRegistro_producao(input);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveRegistro_producao
	 * This is a public operation
	 * The 'retrieve' request primitive for the Registro_producao entity.
	 */
	@Override
	public CompletableFuture<Registro_producao> retrieveRegistro_producaoRequest(Registro_producao.GetRequest input) {
		return this.retrieveRegistro_producaoRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveRegistro_producao
	 * This is a public operation
	 * The 'retrieve' request primitive for the Registro_producao entity.
	*/
	@Override
	public CompletableFuture<Registro_producao> retrieveRegistro_producaoRequest(Registro_producao.GetRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.RetrieveRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.RetrieveRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveRegistro_producaoRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método listRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Registro_producao entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Registro_producao.PagedResults listRegistro_producao(Registro_producao.PageRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ListRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.ListRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.listRegistro_producao(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método listRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Registro_producao entity.
	 */
	@Override
	public void listRegistro_producao(Registro_producao.PageRequest input) {
		br.com.senior.mydomain.myservice.impl.ListRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.ListRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		impl.listRegistro_producao(input);
	}
	
	/**
	 * Chamada assíncrona para o método listRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Registro_producao entity.
	 */
	@Override
	public CompletableFuture<Registro_producao.PagedResults> listRegistro_producaoRequest(Registro_producao.PageRequest input) {
		return this.listRegistro_producaoRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método listRegistro_producao
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Registro_producao entity.
	*/
	@Override
	public CompletableFuture<Registro_producao.PagedResults> listRegistro_producaoRequest(Registro_producao.PageRequest input, long timeout) {
		br.com.senior.mydomain.myservice.impl.ListRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.ListRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.listRegistro_producaoRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateRegistro_producao
	 * This is a public operation
	 * The 'update' request primitive for the Registro_producao entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Registro_producao updateRegistro_producao(Registro_producao input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateRegistro_producao(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateRegistro_producao
	 * This is a public operation
	 * The 'update' request primitive for the Registro_producao entity.
	 */
	@Override
	public void updateRegistro_producao(Registro_producao input) {
		br.com.senior.mydomain.myservice.impl.UpdateRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		impl.updateRegistro_producao(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateRegistro_producao
	 * This is a public operation
	 * The 'update' request primitive for the Registro_producao entity.
	 */
	@Override
	public CompletableFuture<Registro_producao> updateRegistro_producaoRequest(Registro_producao input) {
		return this.updateRegistro_producaoRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateRegistro_producao
	 * This is a public operation
	 * The 'update' request primitive for the Registro_producao entity.
	*/
	@Override
	public CompletableFuture<Registro_producao> updateRegistro_producaoRequest(Registro_producao input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateRegistro_producaoRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateMergeRegistro_producao
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Registro_producao entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Registro_producao updateMergeRegistro_producao(Registro_producao input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateMergeRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergeRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeRegistro_producao(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeRegistro_producao
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Registro_producao entity.
	 */
	@Override
	public void updateMergeRegistro_producao(Registro_producao input) {
		br.com.senior.mydomain.myservice.impl.UpdateMergeRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergeRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMergeRegistro_producao(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeRegistro_producao
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Registro_producao entity.
	 */
	@Override
	public CompletableFuture<Registro_producao> updateMergeRegistro_producaoRequest(Registro_producao input) {
		return this.updateMergeRegistro_producaoRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeRegistro_producao
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Registro_producao entity.
	*/
	@Override
	public CompletableFuture<Registro_producao> updateMergeRegistro_producaoRequest(Registro_producao input, long timeout) {
		br.com.senior.mydomain.myservice.impl.UpdateMergeRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.UpdateMergeRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeRegistro_producaoRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método deleteRegistro_producao
	 * This is a public operation
	 * The 'delete' request primitive for the Registro_producao entity.
	 * @throws MyServiceMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public void deleteRegistro_producao(Registro_producao.Id input, long timeout) {
		br.com.senior.mydomain.myservice.impl.DeleteRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.DeleteRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteRegistro_producao(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método deleteRegistro_producao
	 * This is a public operation
	 * The 'delete' request primitive for the Registro_producao entity.
	 */
	@Override
	public void deleteRegistro_producao(Registro_producao.Id input) {
		br.com.senior.mydomain.myservice.impl.DeleteRegistro_producaoImpl impl = new br.com.senior.mydomain.myservice.impl.DeleteRegistro_producaoImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteRegistro_producao(input);
	}
	
	

	
	private Message createMessage(ImportFuncionarioEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				MyServiceConstants.DOMAIN, //
				MyServiceConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			MyServiceConstants.DOMAIN, // 
			MyServiceConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ExportMaquinaEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				MyServiceConstants.DOMAIN, //
				MyServiceConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			MyServiceConstants.DOMAIN, // 
			MyServiceConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ImportMaquinaEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				MyServiceConstants.DOMAIN, //
				MyServiceConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			MyServiceConstants.DOMAIN, // 
			MyServiceConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ServiceStartedPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				MyServiceConstants.DOMAIN, //
				MyServiceConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			MyServiceConstants.DOMAIN, // 
			MyServiceConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ImportPecaEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				MyServiceConstants.DOMAIN, //
				MyServiceConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			MyServiceConstants.DOMAIN, // 
			MyServiceConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ImportRegistro_producaoEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				MyServiceConstants.DOMAIN, //
				MyServiceConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			MyServiceConstants.DOMAIN, // 
			MyServiceConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ExportFuncionarioEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				MyServiceConstants.DOMAIN, //
				MyServiceConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			MyServiceConstants.DOMAIN, // 
			MyServiceConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(NotifyUserEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				MyServiceConstants.DOMAIN, //
				MyServiceConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			MyServiceConstants.DOMAIN, // 
			MyServiceConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ExportPecaEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				MyServiceConstants.DOMAIN, //
				MyServiceConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			MyServiceConstants.DOMAIN, // 
			MyServiceConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ExportRegistro_producaoEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				MyServiceConstants.DOMAIN, //
				MyServiceConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			MyServiceConstants.DOMAIN, // 
			MyServiceConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	

	/**
	 * Chamada assíncrona para o método publishServiceStarted
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishServiceStarted( ServiceStartedPayload input ) {
		Message message = createMessage(input, MyServiceConstants.Events.SERVICE_STARTED);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new MyServiceException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishNotifyUserEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishNotifyUserEvent( NotifyUserEventPayload input ) {
		Message message = createMessage(input, MyServiceConstants.Events.NOTIFY_USER_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new MyServiceException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishImportPecaEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishImportPecaEvent( ImportPecaEventPayload input ) {
		Message message = createMessage(input, MyServiceConstants.Events.IMPORT_PECA_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new MyServiceException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishExportPecaEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishExportPecaEvent( ExportPecaEventPayload input ) {
		Message message = createMessage(input, MyServiceConstants.Events.EXPORT_PECA_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new MyServiceException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishImportFuncionarioEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishImportFuncionarioEvent( ImportFuncionarioEventPayload input ) {
		Message message = createMessage(input, MyServiceConstants.Events.IMPORT_FUNCIONARIO_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new MyServiceException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishExportFuncionarioEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishExportFuncionarioEvent( ExportFuncionarioEventPayload input ) {
		Message message = createMessage(input, MyServiceConstants.Events.EXPORT_FUNCIONARIO_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new MyServiceException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishImportMaquinaEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishImportMaquinaEvent( ImportMaquinaEventPayload input ) {
		Message message = createMessage(input, MyServiceConstants.Events.IMPORT_MAQUINA_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new MyServiceException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishExportMaquinaEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishExportMaquinaEvent( ExportMaquinaEventPayload input ) {
		Message message = createMessage(input, MyServiceConstants.Events.EXPORT_MAQUINA_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new MyServiceException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishImportRegistro_producaoEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishImportRegistro_producaoEvent( ImportRegistro_producaoEventPayload input ) {
		Message message = createMessage(input, MyServiceConstants.Events.IMPORT_REGISTROPRODUCAO_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new MyServiceException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishExportRegistro_producaoEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishExportRegistro_producaoEvent( ExportRegistro_producaoEventPayload input ) {
		Message message = createMessage(input, MyServiceConstants.Events.EXPORT_REGISTROPRODUCAO_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new MyServiceException("Erro ao enviar a mensagem", e);
		}
	}
	
	private void addMessageHeaders(Message message) {
		message.setUsername(userId.getUsername());
		if (userId.isTrusted()) {
			message.addHeader("trusted", true);
		}
	}
}
