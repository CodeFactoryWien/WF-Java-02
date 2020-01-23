from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("http://exist-fitness-garcia-adopt.trycloudflare.com/")

rooms_link = driver.find_element_by_link_text("Rooms")
rooms_link.click()

time.sleep(0.1)

book_link = driver.find_element_by_xpath("/html/body/div/div[1]/div[4]/a")
book_link.click()

time.sleep(0.1)

first_name_field = driver.find_element_by_id("client_first_name")
first_name_field.send_keys("David")
last_name_field = driver.find_element_by_id("client_last_name")
last_name_field.send_keys("Copperfield")
email_field = driver.find_element_by_id("client_email")
email_field.send_keys("dc@kecske.com")
address_field = driver.find_element_by_id("client_address")
address_field.send_keys("Naschmarkt")
booking_start_date = driver.find_element_by_id("booking_start_date")
booking_start_date.send_keys("25-03-2070")
booking_end_date = driver.find_element_by_id("booking_end_date")
booking_end_date.send_keys("26-03-2070")

book_link = driver.find_element_by_xpath("//*[@id='booking-form']/div[6]/button")
book_link.click()

html_text = driver.page_source


try:
    assert "Thank" in html_text
    print("Booking is successful")
except:
    print("Booking is unsuccessful, room is already booked")

time.sleep(30)

driver.close()


