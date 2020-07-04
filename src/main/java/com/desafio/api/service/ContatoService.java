package com.desafio.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafio.api.model.Contato;
import com.desafio.api.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	/* Retorna um único objeto do tipo Contato */
	public Optional<Contato> buscarContatoById(Integer idContato) {
		return contatoRepository.findById(idContato);
	}

	/* Altera um objeto do tipo Contato */
	public ResponseEntity<Contato> alterarContato(Contato contato, Integer idContato) {

		if (contatoRepository.findContatoById(idContato) == null) {
			return new ResponseEntity<Contato>(HttpStatus.NOT_FOUND);
		}
		contato.getIdContato();
		contato.setNome(contato.getNome());
		contato.setCanal(contato.getCanal());
		contato.setValor(contato.getValor());
		contato.setObs(contato.getObs());

		contatoRepository.save(contato);

		return new ResponseEntity<Contato>(HttpStatus.OK);
	}

	/* Apaga um objeto do tipo Contato */
	public void apagarContato(Integer idContato) {
		contatoRepository.deleteById(idContato);
	}

	/*
	 * 'Retorna uma lista de registros de acordo com o informado nos parâmetros page
	 * e size. Se estes parâmetros não forem passados na consulta, os seguintes
	 * valores padrão serão utilizados: page = 0 e size = 10'
	 */
	public Page<Contato> listaContato(Pageable pageable) {
		return contatoRepository.findAll(pageable);
	}

	/* Cria um novo objeto do tipo Contato */
	public Contato novoContato(Contato contato) {
		contato = new Contato(null, contato.getNome(), contato.getCanal(), contato.getValor(), contato.getObs());

		return contatoRepository.save(contato);
	}

}
