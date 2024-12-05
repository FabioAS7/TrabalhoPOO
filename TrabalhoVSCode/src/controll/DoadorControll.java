package controll;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Doador;
import service.DoadorDAO;
import service.DoadorDAOImpl;


public class DoadorControll {

	private ObservableList<Doador> lista = FXCollections.observableArrayList();

	private IntegerProperty cpf = new SimpleIntegerProperty(0);
	private StringProperty nome = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty<>(LocalDate.now());
	private StringProperty email = new SimpleStringProperty();
	private IntegerProperty telefone = new SimpleIntegerProperty();
	private StringProperty tipoSanguinio = new SimpleStringProperty();

	private DoadorDAO doadorDAO = new DoadorDAOImpl();


	public void entidadeParaTela(Doador d) {
		if (d != null) {
			this.cpf.set(d.getCpf());
			this.nome.set(d.getNome());
			this.nascimento.set(d.getNascimento());
			this.email.set(d.getEmail());
			this.telefone.set(d.getTelefone());
			this.tipoSanguinio.set(d.getTipoSanguinio());
		}
	}

	public void excluir(Doador d) throws Exception {
		System.err.println("Doador excluido");
		doadorDAO.remover(d);
		pesquisarTodos();

	}

	public void gravar() throws Exception {
		Doador d = new Doador();
		d.setCpf(this.cpf.get());
		d.setNome(this.nome.get());
		d.setNascimento(this.nascimento.get());
		d.setEmail(this.email.get());
		d.setTelefone(this.telefone.get());
		d.setTipoSanguinio(this.tipoSanguinio.get());

		pesquisarTodos();
		limparCampos();
	}

	public void pesquisarPorNome() throws Exception {
		lista.clear();
		lista.addAll(doadorDAO.pesquisar(nome.get()));
	}

	public void pesquisarPorVezesImpar(){
		int contador = 0;
		while (!lista.isEmpty()) {
			if(contador % 2 != 0){
				System.out.println(lista.get(contador));
			}
			contador++;
		}

	}

	public void pesquisarTodos() throws Exception {
		lista.clear();
		lista.addAll(doadorDAO.pesquisarTodos());
	}

	public void limparCampos() {
		this.cpf.set(0);
		this.nome.set("");
		this.nascimento.set(LocalDate.now());
		this.email.set("");
		this.telefone.set(0);
		this.tipoSanguinio.set("");
	}

	public ObservableList<Doador> getLista() {
		return lista;
	}

	public IntegerProperty getCpf() {
		return cpf;
	}

	public StringProperty getNome() {
		return nome;
	}

	public ObjectProperty<LocalDate> getNascimento() {
		return nascimento;
	}

	public StringProperty getEmail() {
		return email;
	}

	public IntegerProperty getTelefone() {
		return telefone;
	}

	public StringProperty getTipoSanguinio() {
		return tipoSanguinio;
	}

}
