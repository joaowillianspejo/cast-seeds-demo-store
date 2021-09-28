package massaTeste;

import java.util.Locale;

import com.github.javafaker.Faker;

public class MassaTeste {
	public static final String QTD = "1"; //Faker.instance().number().digit();
	public static final String PAIS = Faker.instance().address().country();
	public static final String ESTADO = Faker.instance().address().state();
	public static final String CIDADE = Faker.instance().address().cityName();
	public static final String CEP = Faker.instance().address().zipCode();
	public static final String NOME = Faker.instance(Locale.getDefault()).name().firstName();
	public static final String NOME_DO_MEIO = NOME;
	public static final String SOBRENOME = Faker.instance(Locale.getDefault()).name().lastName();
	public static final String EMPRESA = Faker.instance(Locale.getDefault()).company().name();
	public static final String EMAIL = Faker.instance().internet().emailAddress();
	public static final String ENDERECO = Faker.instance(Locale.getDefault()).address().streetAddress();
	public static final String ENDERECO2 = ENDERECO;
	public static final String TELEFONE = Faker.instance(Locale.getDefault()).phoneNumber().phoneNumber();
	public static final String FAX = TELEFONE;
	
}
