package br.com.jmmd.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8080/tasks");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		
		try {
			//clicar em add
			driver.findElement(By.id("addTodo")).click();
			
			//digitar a descricao
			
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
			
			//definir uma data
			
			driver.findElement(By.id("dueDate")).sendKeys("18/06/2021");
			
			//clicar em salvar
			
			driver.findElement(By.id("saveButton")).click();
			
			//validar mensagem de sucesso
			
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", message);
		} finally {
			
			//fecha o browser
			driver.quit();
		}

	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		
		try {
			//clicar em add
			driver.findElement(By.id("addTodo")).click();
						
			//definir uma data
			
			driver.findElement(By.id("dueDate")).sendKeys("18/06/2021");
			
			//clicar em salvar
			
			driver.findElement(By.id("saveButton")).click();
			
			//validar mensagem de sucesso
			
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);
		} finally {
			
			//fecha o browser
			driver.quit();
		}

	}
	
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		
		try {
			//clicar em add
			driver.findElement(By.id("addTodo")).click();
			
			//digitar a descricao
			
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
					
			//clicar em salvar
			
			driver.findElement(By.id("saveButton")).click();
			
			//validar mensagem de sucesso
			
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", message);
		} finally {
			
			//fecha o browser
			driver.quit();
		}
	
	}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		WebDriver driver = acessarAplicacao();
		
		try {
			//clicar em add
			driver.findElement(By.id("addTodo")).click();
			
			//digitar a descricao
			
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
			
	        //definir uma data
			
			driver.findElement(By.id("dueDate")).sendKeys("10/06/2010");
					
			//clicar em salvar
			
			driver.findElement(By.id("saveButton")).click();
			
			//validar mensagem de sucesso
			
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", message);
		} finally {
			
			//fecha o browser
			driver.quit();
		}
	
	}
	
	
	
	
	
	

}
