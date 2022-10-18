.PHONY:  all win_dist dist upload

all:
	@echo "Targets:  test, dist, win_wheels, linux_wheel, check_upload, upload"

test:
	tox

win_wheels:
	cmd /C del /q dist\*
	py -3-32 setup.py clean --all
	py -3-32 setup.py bdist_wheel
	py -3-64 setup.py clean --all
	py -3-64 setup.py bdist_wheel

linux_wheel: dist
	python setup.py bdist_wheel

dist:
	rm -f dist/*
	python setup.py clean --all
	python setup.py sdist

upload: check_upload
	twine upload dist/*

check_upload:
	twine check dist/*

