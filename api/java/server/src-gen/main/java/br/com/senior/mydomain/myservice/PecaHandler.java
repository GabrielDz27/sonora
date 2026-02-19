/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import static br.com.senior.SecurityConstants.*;
import static br.com.senior.mydomain.myservice.PecaEntity.SECURITY_RESOURCE;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.messaging.security.SecureResource;
import br.com.senior.custom.metadata.EntityDefProviderImpl;
import br.com.senior.custom.validator.CustomDTOValidatorImpl;
import br.com.senior.springbatchintegration.control.BatchIntegrationController;
import br.com.senior.springbatchintegration.importer.Importer;
import br.com.senior.springbatchintegration.importer.ImporterException;
import br.com.senior.springbatchintegration.model.Layout;
import br.com.senior.mydomain.myservice.Peca.Id;
import br.com.senior.mydomain.myservice.Peca.PageRequest;
import br.com.senior.mydomain.myservice.Peca.PagedResults;
import org.springframework.stereotype.Component;
import br.com.senior.platform.translationhub.api.TranslationHubApi;

@HandlerImpl(serviceClass = MyServiceConstants.class)
@Component("my_domain.my_service.PecaHandler")
public class PecaHandler implements CreatePeca, CreateMergePeca, UpdatePeca, DeletePeca, 
		 UpdateMergePeca, CreateBulkPeca, RetrievePeca, ListPeca, 
		 ImportPeca, ExportPeca {
	static final Logger logger = LoggerFactory.getLogger(PecaHandler.class);
	
	private static final String ID_FIELD_NAME = Arrays.stream(PecaEntity.class.getDeclaredFields())
            .filter(field -> field.isAnnotationPresent(javax.persistence.Id.class))
            .map(Field::getName)
            .findFirst()
            .orElseGet(() -> "id");

	@Inject
	PecaCrudService service;
	
	@Inject
	PecaDTOConverter dtoConverter;
	
	@Inject
	CustomDTOValidatorImpl customValidator;
	
	@Inject
	EntityDefProviderImpl entityDefProvider;
	
	@Inject
	protected TranslationHubApi translationHubApi;
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public Peca createPeca(Peca toCreate) {
		try {
			customValidator.validate(toCreate, entityDefProvider.getEntityDef("peca"));
			PecaEntity entity = service.createPeca(dtoConverter.toEntity(toCreate, true));
			return dtoConverter.toDTO(entity);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("my_domain.my_service.peca_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("my_domain.my_service.peca_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public Peca createMergePeca(Peca toCreate) {
		try {
			PecaEntity entity = service.createPeca(dtoConverter.toEntity(toCreate, false));
			return dtoConverter.toDTO(entity);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("my_domain.my_service.peca_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("my_domain.my_service.peca_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_UPDATE)
	@Transactional
	@Override
	public Peca updatePeca(Peca toUpdate) {
		try {
			customValidator.validate(toUpdate, entityDefProvider.getEntityDef("peca"));
			PecaEntity modified = doUpdate(toUpdate);
			return dtoConverter.toDTO(modified);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("my_domain.my_service.peca_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("my_domain.my_service.peca_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_UPDATE)
	@Transactional
	@Override
	public Peca updateMergePeca(Peca toUpdate) {
		try {
			customValidator.validate(toUpdate, entityDefProvider.getEntityDef("peca"));
			PecaEntity entity = service.retrievePeca(new Peca.Id(toUpdate.id));
			dtoConverter.mergeEntity(entity, toUpdate);
			entity = service.updatePeca(entity);
			return dtoConverter.toDTO(entity);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("my_domain.my_service.peca_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("my_domain.my_service.peca_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	private PecaEntity doUpdate(Peca toUpdate) {
		java.util.Optional<PecaEntity> optionalEntity = service.getRepository().findById(java.util.UUID.fromString(toUpdate.id));
		
		if(optionalEntity.isEmpty())
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.OBJECT_NOT_FOUND, translationHubApi.getExternalMessage("my_domain", "my_service", "my_domain.my_service.peca_notFound", "Peca not found with id " + toUpdate.id));
		
		PecaEntity entity = optionalEntity.get();
		
		dtoConverter.updateEntity(entity, toUpdate);
		return doUpdate(entity);
	}
	
	private PecaEntity doUpdate(PecaEntity entity) {
		return service.updatePeca(entity);
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_DELETE)
	@Transactional
	@Override
	public void deletePeca(Id id) {
		try {
			this.service.deletePeca(id);
		} catch(DataIntegrityViolationException ex) {
			logger.warn(ex.getMessage(), ex);
			if(ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
				org.hibernate.exception.ConstraintViolationException cve = (org.hibernate.exception.ConstraintViolationException) ex.getCause();
				throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getFormattedMessage("my_domain.my_service.delete_constraint_violation", cve.getConstraintName()));
			}
			
			throw new ServiceException(ErrorCategory.CONFLICT, translationHubApi.getMessage("my_domain.my_service.peca_dataIntegrityViolation", "Data integrity violation to Delete Peca. Error: " + ex.getMessage()), ex);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_VIEW)
	@Transactional(readOnly = true)
	@Override
	public Peca retrievePeca(Peca.GetRequest request) {
		PecaEntity entity = service.retrievePeca(new Peca.Id(request.id));
		List<String> displayFields = request.displayFields == null ? getDefaultDisplayFields() : request.displayFields;
		return dtoConverter.toDTO(entity, displayFields);
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_VIEW)
	@Transactional(readOnly = true)
	@Override
	public PagedResults listPeca(PageRequest pageRequest) {
		int skip = pageRequest.offset != null ? pageRequest.offset.intValue() : 0;
		int top = pageRequest.size != null ? pageRequest.size.intValue() : 0;
		String orderBy = pageRequest.orderBy == null ? ID_FIELD_NAME + " asc" : pageRequest.orderBy;
		String filter = pageRequest.filter;
		Page<PecaEntity> pages = this.service.listPecaPageable(skip, top, orderBy, filter);
		List<PecaEntity> entities = pages.getContent();
		List<Peca> dtos = null;
		List<String> displayFields = pageRequest.displayFields == null ? getDefaultDisplayFields() : pageRequest.displayFields;
		
		dtos = entities != null ? entities.stream().map(e -> dtoConverter.toDTO(e, displayFields)).collect(Collectors.toList()) : null;
		return new PagedResults(dtos, Long.valueOf(pages.getTotalPages()), Long.valueOf(pages.getTotalElements()));
	}
	
	public static List<String> getDefaultDisplayFields(){
		List<String> displayFields = new ArrayList<String>();
		displayFields.add("*");
		return displayFields;
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public CreateBulkPecaOutput createBulkPeca(CreateBulkPecaInput toCreate) {
		if (toCreate != null) {
			List<Peca> entitiesToCreate = toCreate.entities;
			if (entitiesToCreate != null && !entitiesToCreate.isEmpty()) {
				entitiesToCreate.forEach(bean -> {
					customValidator.validate(bean, entityDefProvider.getEntityDef("peca"));
					bean.validate();
				});
				
				List<PecaEntity> entities = entitiesToCreate.stream().map(bean -> dtoConverter.toEntity(bean))
						.collect(Collectors.toList());
				this.service.createBulk(entities);
			}
		}
		return new CreateBulkPecaOutput();
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public ImportPecaOutput importPeca(ImportPecaInput request) {
		Importer importer = BatchIntegrationController.getInstance().newImporter();
		StartImportProcess startImportProcess = new StartImportProcess(importer, request.config);
		startImportProcess.start();
		ImportPecaOutput output = new ImportPecaOutput(importer.getId());
		return output;
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_VIEW)
	@Transactional(readOnly = true)
	@Override
	public ExportPecaOutput exportPeca(ExportPecaInput request) {
		/*
		 * **** Not implemented yet **** ExporterControl control =
		 * ExporterControl.getInstance(); Exporter exporter =
		 * control.newExporter(); StartExportProcess startExportProcess = new
		 * StartExportProcess(exporter, request.config);
		 * startExportProcess.start();
		 */
		ExportPecaOutput output = new ExportPecaOutput(
				null /* exporter.getId() */);
		return output;
	}
	
	class StartImportProcess extends Thread {
	
		private Importer importer;
		private ImportConfig config;
		
		StartImportProcess(Importer importer, ImportConfig config) {
			this.importer = importer;
			this.importer.addListener(new PecaImporterListener());
			this.config = config;
			this.importer.logUri(this.config.uri);
		}
		
		@Async
		@Override
		public void run() {
			File blob = getBlobFile();
			try {
				Layout layout = LayoutDTOConverter.dtoToLayout(config.layout);
				try (FileReader reader = new FileReader(blob)) {
					importer.setReader(reader);
					importer.setLayout(layout);
					importer.setBeanClass(Peca.class.getName());
					importer.setCrudService(PecaHandler.this.service, (config.batchSize > 0));
					importer.setBatchSize(config.batchSize);
					if (config.async) {
						importer.startAsync();
					} else {
						try {
							importer.start();
						} catch (ImporterException e) {
							logger.error(e.getMessage(), e);
						}
					}
				}
			} catch (IOException e) {
				// isto nao deveria ocorrer
				logger.error(e.getMessage(), e);
			}
		}
		
		private File getBlobFile() {
			URI uri = null;
			try {
				uri = new URI(config.uri);
			} catch (URISyntaxException e1) {
				logger.error(e1.getMessage(), e1);
			}
			String scheme = uri.getScheme();
			if (scheme.equals("file")) {
				return new File(uri);
			} else if (scheme.startsWith("http")) {
				return getHttpBlobFile(uri);
			}
			return null;
		}
		
		private File getHttpBlobFile(URI uri) {
			importer.notifyDownload();
			HttpGet get = new HttpGet(uri);
			try (CloseableHttpClient httpClient = HttpClients.createDefault();
					CloseableHttpResponse httpResponse = httpClient.execute(get);
					InputStream is = httpResponse.getEntity().getContent()) {
				File blob = File.createTempFile("peca", "blob");
				try (FileOutputStream fos = new FileOutputStream(blob);
						BufferedOutputStream bos = new BufferedOutputStream(fos);
						BufferedInputStream bis = new BufferedInputStream(is)) {
					byte[] bytes = new byte[8192];
					int tam = 0;
					while ((tam = bis.read(bytes)) > 0) {
						bos.write(bytes, 0, tam);
					}
					bos.flush();
					fos.flush();
				}
				return blob;
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
			return null;
		}
	}
}
